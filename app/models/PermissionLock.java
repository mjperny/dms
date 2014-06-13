package models;

import javax.persistence.Entity;

@Entity
public class PermissionLock extends Permission {
	public PermissionLock(long docId){
		this.permissionName = String.format("doc:%s:lock", String.valueOf(docId));
	}
}
