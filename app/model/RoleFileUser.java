package model;

import javax.persistence.Entity;

@Entity
public class RoleFileUser extends Role {
	public RoleFileUser(long docId) {
		super();
		permissions.add(new PermissionReadWrite(docId));
	}
}
