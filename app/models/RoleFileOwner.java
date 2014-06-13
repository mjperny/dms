package models;

import javax.persistence.Entity;

@Entity
public class RoleFileOwner extends RoleFile {
	public RoleFileOwner() {
		super();
		this.roleName = "Owner";
	}
}
