/*
작성자명 : 김대곤
클래스명 : 조리법목록
*/
import java.util.*;
public class RecipeInfoList 
{
	private Collection<RecipeInfo> recipeInfoList;

	public RecipeInfoList()
	{
		this(new LinkedList<RecipeInfo>());
	}
	public RecipeInfoList(Collection<RecipeInfo> recipeInfoList)
	{
		this.recipeInfoList=recipeInfoList;
	}

	public Collection<RecipeInfo> getRecipeInfoList()
	{
		return recipeInfoList;
	}
	public void setRecipeInfoList(Collection<RecipeInfo> recipeInfoList)
	{
		this.recipeInfoList=recipeInfoList;
	}

	public RecipeInfo addRecipeInfoList(RecipeInfo recipeInfo)
	{
		recipeInfoList.add(recipeInfo);
		return recipeInfo;
	}
	public RecipeInfo reviseRecipeInfoList(String foodCode, RecipeInfo recipeInfo)
	{
		int i=0;
		for (RecipeInfo temp : recipeInfoList)
		{
			if(foodCode.equals(temp.getFoodCode()))
			{
				((LinkedList<RecipeInfo>)recipeInfoList).set(i, recipeInfo);
				return recipeInfo;
			}
			i++;
		}
		return null;
	}
	public RecipeInfo removeRecipeInfoList(String foodCode)
	{
		RecipeInfo temp=searchRecipeInfo(foodCode);
		if(temp==null)
			return null;
		recipeInfoList.remove(temp);
		return temp;
	}
	public RecipeInfo searchRecipeInfo(String foodCode)
	{
		for (RecipeInfo temp : recipeInfoList)
		{
			if(foodCode.equals(temp.getFoodCode()))
			{
				return temp;
			}
		}
		return null;
	}
	public Collection<RecipeInfo> searchRecipeInfoList(String foodName)
	{
		LinkedList<RecipeInfo> list=new LinkedList<RecipeInfo>();
		for (RecipeInfo temp : recipeInfoList)
		{
			if(foodName.equals(temp.getFoodName()))
			{
				list.add(temp);
			}
		}
		return list;
	}
}
