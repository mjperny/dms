package model;

import javax.persistence.Entity;

@Entity
public class PermissionReadWrite extends Permission {
	public PermissionReadWrite(long docId){
		this.permissionName = String.format("doc:%lld:readwrite", docId);
	}
}
