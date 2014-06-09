package model;

public enum DocumentType {
	OTHERS("Others"), PICTURE("Picture"), TEXT("Text"), APPLICATION("Application");
	
	private String name;
	
	private DocumentType(String name){
		this.name = name;
	}
}
