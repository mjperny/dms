package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The abstract class of roles, having to do with documents.
 * @author Gary Ye
 * @version 2014-06-13
 */
@Entity
public abstract class RoleFile extends Role {
	@ManyToOne
	@JoinColumn(name="docId")
	protected Document document;

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
}
