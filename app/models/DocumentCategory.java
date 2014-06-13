package models;

/**
 * Represents the category of a document
 * @version 2014-06-07
 */
public enum DocumentCategory {
	ENTERTAINMENT("Entertainment"), WORK("Work"), OTHERS("Others");
	private String name;
	
	/**
	 * The constructor with the given category name
	 * @param name the name of the category
	 */
	private DocumentCategory(String name){
		this.name = name;
	}
	
	/**
	 * Returns the name of the category
	 * @return the name of the category
	 */
	public String toString(){
		return this.name;
	}
}
