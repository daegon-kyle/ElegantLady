//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : RecipeDTO.java
//  @ Date : 2014-05-13
//  @ Author : 장성봉
//
//




public class RecipeDTO {
	private int recipeCode;
	private int recipeTime;
	private String tip;
	private String recipeLevel;
	private int portion;
	private int foodCode;
	public RecipeDTO() {
		this(0,0,"","",0,0);
	}
	
	public RecipeDTO(int recipeCode, int recipeTime, String tip, String recipeLevel, int portion, int foodCode) {
		this.recipeCode = recipeCode;
		this.recipeTime = recipeTime;
		this.tip = tip;
		this.recipeLevel= recipeLevel;
		this.portion = portion;
		this.foodCode = foodCode;
	}
	
	public int getRecipeCode() {
		return this.recipeCode;
	}
	
	public int getRecipeTime() {
		return this.recipeTime;
	}
	
	public String getTip() {
		return this.tip;
	}
	
	public String getRecipeLevel() {
		return this.recipeLevel;
	}
	
	public int getPortion() {
		return this.portion;
	}
	
	public int getFoodCode() {
		return this.foodCode;
	}
	
	public void setRecipeCode(int recipeCode) {
		this.recipeCode =recipeCode;
	}
	
	public void setRecipeTime(int recipeTime) {
		this.recipeTime = recipeTime;
	}
	
	public void setTip(String tip) {
		this.tip =tip;
	}
	
	public void setRecipeLevel(String recipeLevel) {
		this.recipeLevel = recipeLevel;
	}
	
	public void setPortion(int portion) {
		this.portion =portion;
	}
	
	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}
	
	public String toString() {
		return "레시피 코드 : " + recipeCode + " 전체조리시간 : " + recipeTime + " 조리팁 : " + tip + " 난이도 : " + recipeLevel + " 분량 : " + portion + " 음식코드 : " + foodCode;
	}
}
