//  @ File Name : ÃßÃµ¿ä¸®¸ñ·Ï
//  @ Date : 2014/4/28
//  @ Author : ±è´ë°ï
import java.util.*;
public class RecommendedFoodList
{
	private Collection<RecommendedFood> recommendedFoodList;

	public RecommendedFoodList()
	{
		this(new LinkedList<RecommendedFood> ());
	}
	public RecommendedFoodList(Collection<RecommendedFood> recommendedFoodList)
	{
		this.recommendedFoodList=recommendedFoodList;
	}
	
	public Collection<RecommendedFood> getRecommendedFoodList()
	{
		return recommendedFoodList;
	}
	public void setRecommendedFoodList(Collection <RecommendedFood> recommendedFoodList)
	{
		this.recommendedFoodList=recommendedFoodList;
	}

	public RecommendedFood addRecommededFoodList(RecommendedFood recommendedFood)
	{
		recommendedFoodList.add(recommendedFood);
		return recommendedFood;
	}
	public RecommendedFood reviseRecommededFoodList(String foodCode, RecommendedFood recommendedFood)
	{
		int i=0;
		for (RecommendedFood temp : recommendedFoodList)
		{
			if(foodCode.equals(temp.getFoodInfo().getFoodCode()))
			{
				((LinkedList<RecommendedFood>)recommendedFoodList).set(i, recommendedFood);
				return recommendedFood;
			}
			i++;
		}
		return null;
	}
	public RecommendedFood searchRecommededFood(String foodCode)
	{
		for (RecommendedFood temp:recommendedFoodList)
		{
			if(temp.getFoodInfo().getFoodCode().equals(foodCode))
			{
				return temp;
			}
		}
		return null;
	}
	public Collection<RecommendedFood> searchRecommenderFoodList(String foodName)
	{
		LinkedList<RecommendedFood> list=new LinkedList<RecommendedFood>();
		for (RecommendedFood temp : recommendedFoodList)
		{
			if(foodName.equals(temp.getFoodInfo().getFoodName()))
			{
				list.add(temp);
			}
		}
		return list;
	}
	public RecommendedFood removeRecommededFood(String foodCode)
	{
		RecommendedFood temp=searchRecommededFood(foodCode);
		if(temp==null)
			return null;
		recommendedFoodList.remove(temp);
		return temp;
	}
}
