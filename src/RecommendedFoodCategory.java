//
//  @ File Name : 추천음식카테고리
//  @ Date :2014/4/28
//  @ Author : 김대곤
//
//
import java.util.*;
public class RecommendedFoodCategory
{
	private Collection<String> categoryList;

	public RecommendedFoodCategory()
	{
		this(new LinkedList<String>());
	}
	public RecommendedFoodCategory(Collection<String> categoryList)
	{
		this.categoryList=categoryList;
	}
	
	public Collection<String> getCategoryList()
	{
		return categoryList;
	}
	public void setCategoryList(Collection<String> categoryList)
	{
		this.categoryList=categoryList;
	}

	public String addCategoryList(String category)
	{
		categoryList.add(category);
		return category;
	}
	public String reviseCategoryList(String key, String category)
	{
		int i=0;
		for (String temp : categoryList)
		{
			if(key.equals(temp))
			{
				((LinkedList<String>)categoryList).set(i, category);
				return category;
			}
			i++;
		}
		return null;
	}
	public String removeCategoryList(String key)
	{
		String temp=searchCategoryList(key);
		if(temp==null)
			return null;
		categoryList.remove(temp);
		return temp;		
	}
	public String searchCategoryList(String key)
	{
		for (String temp:categoryList )
		{
			if(temp.equals(key))
				return temp;
		}
		return null;
	}
}
