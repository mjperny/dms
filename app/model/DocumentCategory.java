package model;

public enum DocumentCategory {
	ENTERTAINMENT("Entertainment"), WORK("Work"), OTHERS("Others");
	private String name;
	
	private DocumentCategory(String name){
		this.name = name;
	}
}
