//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : RecipeCourseList.java
//  @ Date : 2014-05-13
//  @ Author : �强��
//
//



import  java.util.*;
public class RecipeCourseList {
	private Collection<RecipeCourseDTO> recipeCourseList;
	public RecipeCourseList() {
		this(new LinkedList<RecipeCourseDTO>());
	}
	
	public RecipeCourseList(Collection<RecipeCourseDTO> recipeCourseList) {
		this.recipeCourseList = recipeCourseList;
	}
	
	public RecipeCourseDTO addRecipeCourseList(RecipeCourseDTO recipeCourseDTO) {
		this.recipeCourseList.add(recipeCourseDTO);
		return recipeCourseDTO;
	}
	
	public RecipeCourseDTO removeRecipeList(RecipeCourseDTO recipeCourseDTO) {
		RecipeCourseDTO tmp=searchRecipeCourseList(recipeCourseDTO);
		if(recipeCourseList.remove(tmp))
		{
			return tmp;
		}
		else
		{
			return null;
		}
	}
	
	public RecipeCourseDTO reviseRecipeCourseList(RecipeCourseDTO exRecipeCourseDTO, RecipeCourseDTO newRecipeCourseDTO) {
		int i=0;
		for(RecipeCourseDTO tmp:recipeCourseList)
		{
			if(tmp.getCourseLevel() == newRecipeCourseDTO.getCourseLevel())
			{
				if(tmp.getRecipeCode() == newRecipeCourseDTO.getRecipeCode())
				{
					if(tmp.getRecipeCoursePhoto().equals(newRecipeCourseDTO.getRecipeCoursePhoto()))
					{
						if(tmp.getRecipeCourseTime() == newRecipeCourseDTO.getRecipeCourseTime())
						{
							if(tmp.getRecipeCourseIntro().equals(newRecipeCourseDTO.getRecipeCourseIntro()))
							{
								((LinkedList<RecipeCourseDTO>)recipeCourseList).set(i,newRecipeCourseDTO);
								return newRecipeCourseDTO;
							}
						}
					}
				}
			}
			i++;
		}
		return null;	
	}
	
	public RecipeCourseDTO searchRecipeCourseList(RecipeCourseDTO recipeCourseDTO) {
		int i=0;
		for(RecipeCourseDTO tmp : recipeCourseList)
		{
			if(tmp.getCourseLevel() == recipeCourseDTO.getCourseLevel())
			{
				if(tmp.getRecipeCode() == recipeCourseDTO.getRecipeCode())
				{
					if(tmp.getRecipeCoursePhoto().equals(recipeCourseDTO.getRecipeCoursePhoto()))
					{
						if(tmp.getRecipeCourseTime() == recipeCourseDTO.getRecipeCourseTime())
						{
							if(tmp.getRecipeCourseIntro().equals(recipeCourseDTO.getRecipeCourseIntro()))
							{
								break;
							}
						}
					}
				}
			}
			i++;
		}
		if(i>recipeCourseList.size())
			return null;
		else
			return ((LinkedList<RecipeCourseDTO>)recipeCourseList).get(i);
	}
	public Collection<RecipeCourseDTO> getRecipeCourseList()
	{
		return recipeCourseList;
	}
	public void setRecipeCourseList(Collection<RecipeCourseDTO> recipeCourseList)
	{
		this.recipeCourseList=recipeCourseList;
	}
}