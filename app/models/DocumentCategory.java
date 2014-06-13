package models;

/**
 * 
 * @version 2014-06-07
 */
public enum DocumentCategory {
	ENTERTAINMENT("Entertainment"), WORK("Work"), OTHERS("Others");
	private String name;
	
	private DocumentCategory(String name){
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
}
