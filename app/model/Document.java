package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document {
	@Id
	private long id;

	private String name;

	private String comment;

	private byte[] content;

	private Keyword[] keywords;

	private User author;

	private Version[] versions;

	private DocumentType documentType;

	private DocumentCategory documentCategory;

}
