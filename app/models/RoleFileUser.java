package models;

import javax.persistence.Entity;

/**
 * The role can do what a user can do.
 * @author Gary Ye
 * @versoin 2014-06-13
 */
@Entity
public class RoleFileUser extends RoleFile {
	public RoleFileUser() {
		super();
		this.roleName = "User";
	}
}
