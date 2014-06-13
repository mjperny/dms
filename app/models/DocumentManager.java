package models;

import play.db.jpa.JPA;

/**
 * Objects of this class can manage the documents.
 * The management consists of granting access, creating document and deleting document.
 * @author Gary Ye
 * @version 2014-06-13
 */
public class DocumentManager {
	/**
	 * Creates a new document and create new permissions, and roles corresponding to this document.
	 * @param author the author of the document
	 * @param document the document to create
	 */
	public void createDocument(User author, Document document){
		// Create the permissions
		Permission permissionLock = new PermissionLock(document.getId());
		Permission permissionReadWrite = new PermissionReadWrite(document.getId());
		
		permissionLock.save();
		permissionReadWrite.save();
		
		// Create the corresponding roles
		RoleFile roleFileOwner = new RoleFileOwner();
		roleFileOwner.setDocument(document);
		roleFileOwner.getPermissions().add(permissionLock);
		roleFileOwner.getPermissions().add(permissionReadWrite);
		roleFileOwner.save();
		
		RoleFile roleFileUser = new RoleFileUser();
		roleFileUser.setDocument(document);
		roleFileUser.getPermissions().add(permissionReadWrite);
		roleFileUser.save();
		
		// Now add the author as the author
		author.addCreatedDocuments(document);
		author.getRoles().add(roleFileOwner);
		
		author.save();
		document.save();
		// TODO: Admin ?
	}
	
	/**
	 * Grants the given user the using access to the specified document
	 * @param user the user to grant using access
	 * @param document the document the user is allowed to access
	 */
	public void giveUsingAccess(User user, Document document){
		RoleFile roleFileUser = RoleFileUser.find("byDocId", document.getId()).first();
		user.getRoles().add(roleFileUser);
		user.save();
		document.save();
	}
}
