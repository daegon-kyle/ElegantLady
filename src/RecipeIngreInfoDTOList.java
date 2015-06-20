import java.util.*;
class RecipeIngreInfoDTOList
{
	private Collection<RecipeIngreInfoDTO> recipeIngreInfoList;
	
	public RecipeIngreInfoDTOList()
	{
		this(new LinkedList<RecipeIngreInfoDTO>());
	}
	public RecipeIngreInfoDTOList(Collection<RecipeIngreInfoDTO> list)
	{
		this.recipeIngreInfoList = list;
	}
	public void setRecipeIngreInfoList(Collection<RecipeIngreInfoDTO> list)
	{
		this.recipeIngreInfoList = list;
	}
	public Collection<RecipeIngreInfoDTO> getRecipeIngreInfoList()
	{
		return recipeIngreInfoList;
	}
	public RecipeIngreInfoDTO addRecipeIngreInfoList(RecipeIngreInfoDTO dto)
	{
		recipeIngreInfoList.add(dto);
		return dto;
	}
}