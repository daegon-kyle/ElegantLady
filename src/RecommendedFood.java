 
//  @ File Name : ��õ�丮
//  @ Date : 2014/4/28
//  @ Author : ����
public class RecommendedFood
{
	private IngredientInfo ingredientInfo;
	private FoodInfo foodInfo;

	public RecommendedFood()
	{
		this(new IngredientInfo(), new FoodInfo());
	}
	
	public RecommendedFood(IngredientInfo ingredientInfo, FoodInfo foodInfo)
	{
		this.ingredientInfo=ingredientInfo;
	}
	
	public IngredientInfo getIngredientInfo()
	{
		return ingredientInfo;
	}
	public FoodInfo getFoodInfo()
	{
		return foodInfo;
	}
	public void setIngredientInfo(IngredientInfo ingredientInfo)
	{
		this.ingredientInfo=ingredientInfo;
	}
	public void setFoodInfo(FoodInfo foodInfo)
	{
		this.foodInfo=foodInfo;
	}
}
