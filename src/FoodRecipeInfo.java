//������
//������������(��������+������)
public class FoodRecipeInfo
{
	private FoodInfo foodInfo;
	private RecipeInfo recipeInfo;
	
	public FoodRecipeInfo()
	{
		this(new FoodInfo(),new RecipeInfo());
	}
	public FoodRecipeInfo(FoodInfo foodInfo,RecipeInfo recipeInfo)
	{
		this.foodInfo=foodInfo;
		this.recipeInfo=recipeInfo;
	}
	public FoodInfo getFoodInfo()
	{
		return foodInfo;
	}
	public RecipeInfo getRecipeInfo()
	{
		return recipeInfo;
	}
	public void setFoodInfo(FoodInfo foodInfo)
	{
		this.foodInfo=foodInfo;
	}
	public void setRecipeInfo(RecipeInfo recipeInfo)
	{
		this.recipeInfo=recipeInfo;
	}
}  
