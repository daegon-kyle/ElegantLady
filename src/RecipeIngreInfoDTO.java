public class RecipeIngreInfoDTO
{
	private	int foodCode;
	private String foodName;
	private String ingredientName;
	private int ingredientCode;
	private int ingredientNum;

	public RecipeIngreInfoDTO()
	{
		this(0,"","",0,0);
	}
	public RecipeIngreInfoDTO(int foodCode, String foodName,String ingredientName,int ingredientCode,int ingredientNum)
	{
		this.foodCode = foodCode;
		this.foodName = foodName;
		this.ingredientName = ingredientName;
		this.ingredientCode = ingredientCode;
		this.ingredientNum = ingredientNum;
	}

	public int getFoodCode()
	{
		return foodCode;
	}
	public String getFoodName()
	{
		return foodName;
	}
	public String getIngredientName()
	{
		return ingredientName;
	}
	public int getIngredientCode()
	{
		return ingredientCode;
	}
	public int getIngredientNum()
	{
		return ingredientNum;
	}

	public void setFoodCode(int foodCode)
	{
		this.foodCode = foodCode;
	}
	public void setFoodName(String foodName)
	{
		this.foodName = foodName;
	}
	public void setIngredientName(String ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientCode(int ingredientCode)
	{
		this.ingredientCode = ingredientCode;
	}
	public void setIngredientNum(int ingredientNum)
	{
		this.ingredientNum = ingredientNum;
	}
	public String toString()
	{
		return "";
	}
}