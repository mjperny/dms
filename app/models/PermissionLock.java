package models;

import javax.persistence.Entity;

/**
 * Allows the permitted user to lock the document.
 * @author Gary Ye
 * @version 2014-06-13
 */
@Entity
public class PermissionLock extends Permission {
	public PermissionLock(long docId){
		this.permissionName = String.format("doc:%s:lock", String.valueOf(docId));
	}
}
