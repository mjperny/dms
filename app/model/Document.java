package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This is the document class. These documents will be persisted in the database, so that
 * the user can retrieve it later.
 * @version 2014-06-07
 */
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the lockedStatus
	 */
	public boolean isLockedStatus() {
		return lockedStatus;
	}

	/**
	 * @param lockedStatus the lockedStatus to set
	 */
	public void setLockedStatus(boolean lockedStatus) {
		this.lockedStatus = lockedStatus;
	}

	/**
	 * @return the versions
	 */
	public Collection<DocumentVersion> getVersions() {
		return versions;
	}

	/**
	 * @param versions the versions to set
	 */
	public void setVersions(Collection<DocumentVersion> versions) {
		this.versions = versions;
	}

	/**
	 * @return the keywords
	 */
	public Collection<Keyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Collection<Keyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	/**
	 * @return the documentCategory
	 */
	public DocumentCategory getDocumentCategory() {
		return documentCategory;
	}

	/**
	 * @param documentCategory the documentCategory to set
	 */
	public void setDocumentCategory(DocumentCategory documentCategory) {
		this.documentCategory = documentCategory;
	}
	
	
	
	
}
