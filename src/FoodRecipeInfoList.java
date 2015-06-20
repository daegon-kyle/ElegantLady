//양진영
//요리정보리스트
import java.util.*;
public class FoodRecipeInfoList 
{
	static private Collection<FoodRecipeInfo> foodRecipeInfoList;
	static
	{
		foodRecipeInfoList=new LinkedList<FoodRecipeInfo>();
	}
	static public Collection<FoodRecipeInfo> getFoodRecipeInfoList()
	{
		return FoodRecipeInfoList.foodRecipeInfoList;
	}
	static public void setFoodRecipeInfoList(Collection<FoodRecipeInfo> foodRecipeInfoList)
	{
		FoodRecipeInfoList.foodRecipeInfoList=foodRecipeInfoList;
	}
	static public FoodRecipeInfo addFoodRecipeInfoList(FoodRecipeInfo foodRecipeInfo)
	{
		foodRecipeInfoList.add(foodRecipeInfo);
		return null;
	}
	static public FoodRecipeInfo searchFoodRecipeInfo(String foodCode)
	{
		for (FoodRecipeInfo temp:foodRecipeInfoList)
		{
			if(temp.getFoodInfo().getFoodCode().equals(foodCode))
			{
				return temp;
			}
		}
		return null;
	}
	static public Collection<FoodRecipeInfo> searchFoodRecipeInfoList(String foodName)
	{
		LinkedList<FoodRecipeInfo> list=new LinkedList<FoodRecipeInfo>();
		int size=foodRecipeInfoList.size();
		int cnt=1;
		for (FoodRecipeInfo temp : FoodRecipeInfoList.foodRecipeInfoList)
		{
			if(cnt==size+1)
				break;
			if(temp.getFoodInfo().getFoodName().equals(foodName))
			{
				list.add(temp);
			}
			cnt++;
		}
		return list;
	}
	static public Collection<FoodRecipeInfo> searchTodayFood(String keyword)
	{
		LinkedList<FoodRecipeInfo> list=new LinkedList<FoodRecipeInfo> ();
		int size=foodRecipeInfoList.size();
		int cnt=1;
		for (FoodRecipeInfo temp : foodRecipeInfoList)
		{
			if(cnt==size+1)
				break;
			if(temp.getFoodInfo().getFoodName().contains(keyword))
			{
				list.add(temp);
			}
			cnt++;
		}
		return list;
	}
	static public Collection<FoodRecipeInfo> searchFoodRecipeInfoList(String ingred1,String ingred2,String ingred3)
	{
		LinkedList<FoodRecipeInfo> list = new LinkedList<FoodRecipeInfo>();
		for(FoodRecipeInfo foodRecipeInfo : foodRecipeInfoList)
		{
			if(foodRecipeInfo.getRecipeInfo().check(ingred1,ingred2,ingred3))
			list.add(foodRecipeInfo);
		}
		return list;
	}
	static FoodRecipeInfo reviseFoodRecipeInfoList(String foodCode,FoodRecipeInfo foodRecipeInfo)
	{
		int i=0;
		for(FoodRecipeInfo tmp:foodRecipeInfoList)
		{
			if(tmp.getFoodInfo().getFoodCode().equals(foodCode))
			{
				((LinkedList<FoodRecipeInfo>)foodRecipeInfoList).set(i,foodRecipeInfo);
				return foodRecipeInfo;
			}
			i++;
		}
		return null;
	}
	static FoodRecipeInfo removeFoodRecipeInfoList(String foodCode)
	{
		int i=0;
		for(FoodRecipeInfo tmp:foodRecipeInfoList)
		{
			if(tmp.getFoodInfo().getFoodCode().equals(foodCode))
			{
				((LinkedList<FoodRecipeInfo>)foodRecipeInfoList).remove(i);
				return tmp;
			}
			i++;
		}
		return null;
	}
}
