/*
작성자명 : 김대곤
클래스명 : 조리법
*/

public class  RecipeInfo
{
	private String foodName;
	private int cookingTotalTime;
	private String tip;
	private int portion;
	private Level level;
	private String foodCode;
	private CookingCourseList cookingCourseList;
	private RecipeIngreInfoList recipeIngreInfoList;

	public RecipeInfo()
	{
		this("",0,"",0,Level.EASY,new CookingCourseList(), new RecipeIngreInfoList());
	}
	public RecipeInfo(String foodName, int cookingTotalTime, String tip, int portion, Level level,CookingCourseList cookingCourseList, RecipeIngreInfoList recipeIngreInfoList)
	{
		this.foodName=foodName;
		this.cookingTotalTime=cookingTotalTime;
		this.tip=tip;
		this.portion=portion;
		this.level=level;
		this.cookingCourseList=cookingCourseList;
		this.recipeIngreInfoList=recipeIngreInfoList;
	}
	public RecipeInfo(String foodName, int cookingTotalTime, String tip, int portion, Level level, String foodCode, CookingCourseList cookingCourseList, RecipeIngreInfoList recipeIngreInfoList)
	{
		this(foodName, cookingTotalTime, tip, portion, level, cookingCourseList, recipeIngreInfoList);
		this.foodCode=foodCode;
	}

	public String getFoodName()
	{
		return foodName;
	}
	public int getCookingTotalTime()
	{
		return cookingTotalTime;
	}
	public String getTip()
	{
		return tip;
	}
	public int getPortion()
	{
		return portion;
	}
	public Level getLevel()
	{
		return level;
	}
	public String getFoodCode()
	{
		return foodCode;
	}
	public CookingCourseList getCookingCourseList()
	{
		return cookingCourseList;
	}
	public RecipeIngreInfoList getRecipeIngreInfoList()
	{
		return recipeIngreInfoList;
	}
	public void setFoodName(String foodName)
	{
		this.foodName=foodName;
	}
	public void setCookingTotalTime(int cookingTotalTime)
	{
		this.cookingTotalTime=cookingTotalTime;
	}
	public void setTip(String tip)
	{
		this.tip=tip;
	}
	public void setPortion(int portion)
	{
		this.portion=portion;
	}
	public void setLevel(Level level)
	{
		this.level=level;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public void setCookingCourseList(CookingCourseList cookingCourseList)
	{
		this.cookingCourseList=cookingCourseList;
	}
	public void setRecipeIngreInfoList(RecipeIngreInfoList recipeIngreInfoList)
	{
		this.recipeIngreInfoList=recipeIngreInfoList;
	}
	public boolean check(String ingred1, String ingred2, String ingred3)  //재료명
	{
		if(recipeIngreInfoList.searchRecipeIngreName(ingred1)!=null)
		{
			if(recipeIngreInfoList.searchRecipeIngreName(ingred2)!=null)
			{
				if(recipeIngreInfoList.searchRecipeIngreName(ingred3)!=null)
				{
					return true;
				}
			}
		}
		return false;
	}
}
