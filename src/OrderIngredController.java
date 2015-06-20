import java.util.*;
public class OrderIngredController
{
	private String foodCode;

	public OrderIngredController()
	{
		this("");
	}
	public OrderIngredController(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public String getFoodCode()
	{
		return this.foodCode;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public String searchFoodName()
	{
		System.out.println(foodCode);
		FoodRecipeInfo tmp=FoodRecipeInfoList.searchFoodRecipeInfo(foodCode);
		return tmp.getFoodInfo().getFoodName();
	}
	public String[] searchStoreName()
	{
		ArrayList<String> result=new ArrayList<String>();
		for(StoreItemInfo tmp:StoreItemInfoList.getStoreItemInfoList())
		{
			result.add(tmp.getStoreInfo().getStoreName());
		}
		String[] tmp=new String[result.size()];
		return tmp;			
	}
	public String[] searchStoreTime()
	{
		String[] time=new String[]{"12:00~13:00","13:00~14:00","14:00~15:00"};
		return time;
	}
	public String[] searchRecipeIngredList()
	{
		FoodRecipeInfo tmp=FoodRecipeInfoList.searchFoodRecipeInfo(foodCode);
		RecipeIngreInfoList tmp1=tmp.getRecipeInfo().getRecipeIngreInfoList();
		String[] result=new String[tmp1.getRecipeIngreInfoList().size()];
		int i=0;
		for(RecipeIngreInfo temp:tmp1.getRecipeIngreInfoList())
		{
			result[i]=temp.getIngredientName();
		}
		return result;
	}
}  
