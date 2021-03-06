//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : RecipeList.java
//  @ Date : 2014-05-13
//  @ Author : �强��
//
//



import  java.util.*;
public class RecipeList {
	private Collection<RecipeDTO> recipeList;
	public RecipeList() {
		this(new LinkedList<RecipeDTO>());
	}
	
	public RecipeList(Collection<RecipeDTO> recipeList) {
		this.recipeList = recipeList;
	}
	
	public RecipeDTO addRecipeList(RecipeDTO recipeDTO) {
		this.recipeList.add(recipeDTO);
		return recipeDTO;
	}
	
	public RecipeDTO removeRecipeList(RecipeDTO recipeDTO) {
		RecipeDTO tmp=searchRecipeList(recipeDTO);
		if(recipeList.remove(tmp))
		{
			return tmp;
		}
		else
		{
			return null;
		}
	}
	
	public RecipeDTO reviseRecipeList(RecipeDTO exRecipeDTO, RecipeDTO newRecipeDTO) {
		int i=0;
		for(RecipeDTO tmp:recipeList)
		{
			if(tmp.getRecipeCode() == newRecipeDTO.getRecipeCode())
			{
				if(tmp.getRecipeTime() == newRecipeDTO.getRecipeTime())
				{
					if(tmp.getTip().equals(newRecipeDTO.getTip()))
					{
						if(tmp.getRecipeLevel().equals(newRecipeDTO.getRecipeLevel()))
						{
							if(tmp.getPortion()== newRecipeDTO.getPortion())
							{
								if(tmp.getFoodCode() == newRecipeDTO.getFoodCode())
								{
									((LinkedList<RecipeDTO>)recipeList).set(i,newRecipeDTO);
									return newRecipeDTO;
								}
							}
						}
					}
				}
			}
			i++;
		}
		return null;
	}
	
	public RecipeDTO searchRecipeList(RecipeDTO recipeDTO) {
		int i=0;
		for(RecipeDTO tmp : recipeList)
		{
			if(tmp.getRecipeCode() == recipeDTO.getRecipeCode())
			{
				if(tmp.getRecipeTime() == recipeDTO.getRecipeTime())
				{
					if(tmp.getTip().equals(recipeDTO.getTip()))
					{
						if(tmp.getRecipeLevel().equals(recipeDTO.getRecipeLevel()))
						{
							if(tmp.getPortion()== recipeDTO.getPortion())
							{
								if(tmp.getFoodCode() == recipeDTO.getFoodCode())
								{
									break;
								}
							}
						}
					}
				}
			}
			i++;
		}
		if(i>recipeList.size())
			return null;
		else
			return ((LinkedList<RecipeDTO>)recipeList).get(i);
	}
	public Collection<RecipeDTO> getRecipeList()
	{
		return recipeList;
	}
	public void setRecipeList(Collection<RecipeDTO> recipeList)
	{
		this.recipeList=recipeList;
	}
}
