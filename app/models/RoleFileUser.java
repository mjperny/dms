package models;

import javax.persistence.Entity;

@Entity
public class RoleFileUser extends RoleFile {
	public RoleFileUser() {
		super();
		this.roleName = "User";
	}
}
