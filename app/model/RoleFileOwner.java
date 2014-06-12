package model;

import javax.persistence.Entity;

@Entity
public class RoleFileOwner extends Role {
	public RoleFileOwner(long docId) {
		permissions.add(new PermissionReadWrite(docId));
		permissions.add(new PermissionLock(docId));
	}
}
