package models;

import play.db.jpa.JPA;

/**
 * This class will manage the permissions of the documents.
 * The permissions should look like doc:$docid:$permission
 * Where $permission can be {read, write, delete}
 * As an owner of $docid you can get permissions to doc:...:...
 * @author Gary Ye
 * @version 
 */
public class PermissionManager {
	private static PermissionManager instance;
	
	private PermissionManager(){
	}

	public static PermissionManager getInstance(){
		if(instance == null){
			instance = new PermissionManager();
		}
		return instance;
	}

	/**
	 * Grants access to a user by giving him a role.
	 * @param user the user to be granted the access
	 * @param role the role given to the user
	 */
	public void grantAccess(User user, Role role){
		user.getRoles().add(role);
		user.save();
	}
}
