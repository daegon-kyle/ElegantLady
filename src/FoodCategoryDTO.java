//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FoodCategoryDTO.java
//  @ Date : 2014-05-13
//  @ Author : ������
//
//




public class FoodCategoryDTO {
	private int foodCategoryCode;
	private int foodCode;
	private int secondCategoryCode;
	public FoodCategoryDTO() {
		this(0,0,0);
	}
	
	public FoodCategoryDTO(int foodCategoryCode, int foodCode, int secondCategoryCode) {
		this.foodCategoryCode=foodCategoryCode;
		this.foodCode=foodCode;
		this.secondCategoryCode=secondCategoryCode;
	}
	
	public int getFoodCategoryCode() {
		return this.foodCategoryCode;
	}
	
	public int getFoodCode() {
		return this.foodCode;
	}
	
	public int getSecondCategoryCode() {
		return this.secondCategoryCode;
	}
	
	public void setFoodCategoryCode(int foodCategoryCode) {
		this.foodCategoryCode=foodCategoryCode;
	}
	
	public void setFoodCode(int foodCode) {
		this.foodCode=foodCode;
	}
	
	public void setSecondCategoryCode(int secondCategoryCode) {
		this.secondCategoryCode=secondCategoryCode;
	}
	
	public String toString() {
		return foodCategoryCode+"/"+foodCode+"/"+secondCategoryCode;
	}
}
