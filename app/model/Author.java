package model;

import javax.persistence.*;

@Entity
public class Author extends User {
	@Id @GeneratedValue
	private long id;

	private Document[] document;
}
