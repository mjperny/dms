package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id @GeneratedValue
	private long id;
	
	@Column(unique=true, nullable=false)
	private String name;

	@OneToMany
	private Collection<Document> createdDocuments;
}
