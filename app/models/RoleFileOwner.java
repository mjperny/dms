package models;

import javax.persistence.Entity;

/**
 * The role of an owner of a document
 * @author Gary Ye
 * @version 2014-06-13
 */
@Entity
public class RoleFileOwner extends RoleFile {
	public RoleFileOwner() {
		super();
		this.roleName = "Owner";
	}
}
