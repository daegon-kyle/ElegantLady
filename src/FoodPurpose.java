/*
작성자명 : 김대곤
클래스명 : 음식목적
*/
import java.util.*;
public class  FoodPurpose
{
	private Collection<FoodType> foodTypeList;
	public FoodPurpose()
	{
		this(new LinkedList<FoodType>());
	}
	public FoodPurpose(Collection<FoodType> foodTypeList)
	{
		this.foodTypeList=foodTypeList;
	}

	public Collection<FoodType> getFoodTypeList()
	{
		return foodTypeList;
	}
	public void setFoodTypeList(Collection<FoodType> foodTypeList)
	{
		this.foodTypeList=foodTypeList;
	}

	public FoodType addFoodTypeList(FoodType foodType)
	{
		foodTypeList.add(foodType);
		return foodType;
	}
	public FoodType reviseFoodTypeList(String foodCode, FoodType foodType)
	{
		int i=0;
		for (FoodType temp : foodTypeList)
		{
			if(foodCode.equals(temp.getFoodInfo().getFoodCode()))
			{
				((LinkedList<FoodType>)foodTypeList).set(i, foodType);
				return foodType;
			}
			i++;
		}
		return null;
	}
	public FoodType removeFoodTypeList(String foodCode)
	{
		FoodType temp=searchFoodType(foodCode);
		if(temp==null)
			return null;
		foodTypeList.remove(temp);
		return temp;
	}
	public FoodType searchFoodType(String foodCode)
	{
		for (FoodType temp : foodTypeList)
		{
			if(foodCode.equals(temp.getFoodInfo().getFoodCode()))
			{
				return temp;
			}
		}
		return null;
	}
	public Collection<FoodType> searchFoodTypeList(String foodName)
	{
		LinkedList<FoodType> list=new LinkedList<FoodType>();
		for (FoodType temp : foodTypeList)
		{
			if(foodName.equals(temp.getFoodInfo().getFoodName()))
			{
				list.add(temp);
			}
		}
		return list;
	}
}
