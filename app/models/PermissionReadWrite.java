package models;

import javax.persistence.Entity;

@Entity
public class PermissionReadWrite extends Permission {
	public PermissionReadWrite(long docId){
		this.permissionName = String.format("doc:%s:readwrite", String.valueOf(docId));
	}
}
