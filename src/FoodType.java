/*
작성자명 : 김대곤
클래스명 : 음식유형
*/
import java.util.*;
public class FoodType 
{
	private String foodTypeName;
	private FoodRecipeInfoList foodRecipeInfoList;
	private FoodInfo foodInfo;

	public FoodType()
	{
		this("", new FoodRecipeInfoList(), new FoodInfo());
	}
	public FoodType(String foodTypeName, FoodRecipeInfoList foodRecipeInfoList, FoodInfo foodInfo)
	{
		this.foodTypeName=foodTypeName;
		this.foodRecipeInfoList=foodRecipeInfoList;
		this.foodInfo=foodInfo;
	}

	public String getFoodTypeName()
	{
		return foodTypeName;
	}
	public FoodRecipeInfoList getFoodRecipeInfoList()
	{
		return foodRecipeInfoList;
	}
	public FoodInfo getFoodInfo()
	{
		return foodInfo;
	}
	public void setFoodTypeName(String foodTypeName)
	{
		this.foodTypeName=foodTypeName;
	}
	public void setFoodRecipeInfoList(FoodRecipeInfoList foodRecipeInfoList)
	{
		this.foodRecipeInfoList=foodRecipeInfoList;
	}
	public void setFoodInfo(FoodInfo foodInfo)
	{
		this.foodInfo=foodInfo;
	}
}
