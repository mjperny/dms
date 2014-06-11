package model;

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
public class User {
	@Id @GeneratedValue
	private long id;
	
	@Column(unique=true, nullable=false)
	private String name;
	
	@Column
	private String password;
	
	@Column
	@ManyToMany
	private Collection<Role> roles;

	@OneToMany(mappedBy="author")
	private Collection<Document> createdDocuments;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
