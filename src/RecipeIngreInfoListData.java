import java.util.*;
public class RecipeIngreInfoListData 
{
	private Collection<RecipeIngreInfoList> recipeIngreInfoListData;

	public RecipeIngreInfoListData()
	{
		this(new LinkedList<RecipeIngreInfoList>());
	}
	public RecipeIngreInfoListData(Collection<RecipeIngreInfoList> recipeIngreInfoListData)
	{
		this.recipeIngreInfoListData=recipeIngreInfoListData;
	}
	public Collection<RecipeIngreInfoList> getRecipeIngreInfoList()
	{
		return recipeIngreInfoListData;
	}
	public void setRecipeIngreInfoList(Collection<RecipeIngreInfoList> recipeIngreInfoListData)
	{
		this.recipeIngreInfoListData=recipeIngreInfoListData;
	}
	public RecipeIngreInfoList addRecipeIngreInfoList(RecipeIngreInfoList recipeIngreInfoList)
	{
		if(recipeIngreInfoListData.add(recipeIngreInfoList))
		{
			return recipeIngreInfoList;
		}
		else
		{
			return null;
		}
	}
	public RecipeIngreInfoList reviseRecipeIngreInfoList(RecipeIngreInfoList searchRecipeIngreInfoList,RecipeIngreInfoList changeRecipeIngreInfoList)
	{
		return null;
	}
	public RecipeIngreInfoList removeRecipeIngreInfoList(RecipeIngreInfoList recipeIngreInfoList)
	{
		return null;
	}
	public RecipeIngreInfoList searchRecipeIngreIngoList(RecipeIngreInfoList recipeIngreInfoList)
	{
		return null;
	}
}
