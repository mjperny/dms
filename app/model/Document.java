package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Document {
	@Id @GeneratedValue
	private long id;

	@Column(nullable=false)
	private String name;

	private String comment;
	
	private boolean lockedStatus;

	@OneToMany(mappedBy="document")
	private Collection<DocumentVersion> versions;

	@OneToMany
	private Collection<Keyword> keywords;
	@ManyToOne
	@JoinColumn(name="authorid")
	private User author;

	@Enumerated(EnumType.STRING)
	private DocumentType documentType;

	@Enumerated(EnumType.STRING)
	private DocumentCategory documentCategory;
}
