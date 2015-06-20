/*
 작성자  : 장성봉
 클래스명 : 재료별레시피 // RecipePerIngredient
*/
import java.util.*;
public class  RecipePerIngredient
{
	private Collection<String> foodTypeList;
	////생성자
	public RecipePerIngredient()
	{
		this(new LinkedList<String>());
	}
	public RecipePerIngredient(Collection<String> foodTypeList)
	{
		this.foodTypeList = foodTypeList;
	}
	////getter/setter
	public Collection<String> getFoodTypeList()
	{
		return this.foodTypeList;
	}
	public void setFoodTypeList(Collection<String> foodTypeList)
	{
		this.foodTypeList = foodTypeList;
	}
	////add
	public String addFoodType(String foodType)
	{
		this.foodTypeList.add(foodType);
		return foodType;
	}
	////revise
	public String reviseFoodTypeList(String foodType,String changeType)
	{
		int i=0;
		for(String str : foodTypeList)
		{
			if(str.equals(foodType))
			{
				try
				{
					((LinkedList<String>)foodTypeList).set(i,changeType);
					return str;
				}
				catch (IndexOutOfBoundsException e)
				{
					return null;
				}
			}
			i++;
		}
		return null;
	}
	////remove
	public String removeFoodTypeList(String foodType)
	{
		String str = searchFoodType(foodType);
		if(str !=null)
		{
			this.foodTypeList.remove(str);
			return foodType;
		}
		return null;
	}
	////search
	public String searchFoodType(String foodType)
	{
		for(String str : foodTypeList)
		{
			if(str.equals(foodType))
			{
				return str;
			}
		}
		return null;
	}
	////search
	public Collection<String> searchFoodTypeList(String foodType)
	{
		LinkedList<String> list = new LinkedList<String>();
		for(String str : foodTypeList)
		{
			if(str.equals(foodType))
			{
				list.add(str);
			}
		}
		return list;
	}
}
