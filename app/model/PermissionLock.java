package model;

import javax.persistence.Entity;

@Entity
public class PermissionLock extends Permission {
	public PermissionLock(long docId){
		this.permissionName = String.format("doc:%lld:lock", docId);
	}
}
