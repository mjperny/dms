package models;

import javax.persistence.Entity;

/**
 * Allows the permitted user to read and write the document
 * @author Gary Ye
 * @version 2014-06-07
 */
@Entity
public class PermissionReadWrite extends Permission {
	public PermissionReadWrite(long docId){
		this.permissionName = String.format("doc:%s:readwrite", String.valueOf(docId));
	}
}
