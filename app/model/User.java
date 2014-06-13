package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * 
 * @version 2014-06-07
 */
@Entity
public class User extends play.db.jpa.Model{
	private static final long serialVersionUID = -8218575344530428444L;

	@Column(unique=true, nullable=false)
	private String name;
	
	@Column
	private String password;
	
	@Column
	@ManyToMany
	private Collection<Role> roles;

	@OneToMany(mappedBy="author")
	private Collection<Document> createdDocuments;

	
	public User() {
		this.roles = new ArrayList<>();
		this.createdDocuments = new ArrayList<>();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the createdDocuments
	 */
	public Collection<Document> getCreatedDocuments() {
		return createdDocuments;
	}

	/**
	 * @param createdDocuments the createdDocuments to set
	 */
	public void setCreatedDocuments(Collection<Document> createdDocuments) {
		this.createdDocuments = createdDocuments;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public Collection<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
