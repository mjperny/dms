package models;

/**
 * The type of the document.
 * @version 2014-06-07
 */
public enum DocumentType {
	OTHERS("Others"), PICTURE("Picture"), TEXT("Text"), APPLICATION("Application");
	
	private String name;
	
	/**
	 * Constructor with a given name.
	 * @param name the name of the type
	 */
	private DocumentType(String name){
		this.name = name;
	}
	
	/**
	 * Returns the name of the type
	 * @return the name of the type
	 */
	public String toString(){
		return name;
	}
}
