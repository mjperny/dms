package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Role extends Model {
	@Column
	protected String roleName;
	
	@Column
	@ManyToMany
	protected Collection<Permission> permissions;
	
	public Role(){
		permissions = new ArrayList<>();
	}
	
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the permissions
	 */
	public Collection<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
}
