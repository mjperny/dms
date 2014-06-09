package model;

public class Document {

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
