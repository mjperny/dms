package model;

import javax.persistence.Entity;

@Entity
public class RoleFileOwner extends Role {
	public RoleFileOwner(long docId) {
		super();
		Permission permission = new PermissionReadWrite(docId);
		permission.save();
		
		Permission permission2 = new PermissionLock(docId);
		permission2.save();
		
		permissions.add(permission);
		permissions.add(permission2);
	}
}
