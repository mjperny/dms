package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@OneToMany
	private Collection<Document> versions;

	@OneToMany
	private Collection<Keyword> keywords;
	
	@ManyToOne
	private User author;

	@Embedded
	private DocumentType documentType;

	@Embedded
	private DocumentCategory documentCategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isLockedStatus() {
		return lockedStatus;
	}

	public void setLockedStatus(boolean lockedStatus) {
		this.lockedStatus = lockedStatus;
	}

	public Collection<Document> getVersions() {
		return versions;
	}

	public void setVersions(Collection<Document> versions) {
		this.versions = versions;
	}

	public Collection<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Collection<Keyword> keywords) {
		this.keywords = keywords;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public DocumentCategory getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(DocumentCategory documentCategory) {
		this.documentCategory = documentCategory;
	}

	
	
}
