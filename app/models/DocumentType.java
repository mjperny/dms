package models;

/**
 * @version 2014-06-07
 */
public enum DocumentType {
	OTHERS("Others"), PICTURE("Picture"), TEXT("Text"), APPLICATION("Application");
	
	private String name;
	
	private DocumentType(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
