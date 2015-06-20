
//  @ Project : Untitled
//  @ File Name : FirstCategoryDTO.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//




public class FirstCategoryDTO {
	private int firstCategoryCode;
	private String firstCategoryName;
	public FirstCategoryDTO() {
		this(0,"");
	}
	
	public FirstCategoryDTO(int firstCategoryCode, String firstCategoryName) {
		this.firstCategoryCode = firstCategoryCode;
		this.firstCategoryName = firstCategoryName;
	}
	
	public int getFirstCategoryCode() {
		return firstCategoryCode;
	}
	
	public String getFistCategoryName() {
		return firstCategoryName;
	}
	
	public void setFirstCategoryCode(int firstCategoryCode) {
		this.firstCategoryCode = firstCategoryCode;
	}
	
	public void setFirstCategoryName(String fistCategoryName) {
		this.firstCategoryName = firstCategoryName;
	}
	
	public String toString() {
		return "firstCategoryCode : "+firstCategoryCode+"firstCategoryName : "+firstCategoryName;
	}
}
