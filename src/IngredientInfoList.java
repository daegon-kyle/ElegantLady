/*
	작성자 : 장성봉
	클래스명 : IngredientInfoList
*/
import java.util.*;
public class IngredientInfoList
{
	private Collection<IngredientInfo> ingredientInfoList;
	private String foodName;
	public IngredientInfoList()
	{
		this(new LinkedList<IngredientInfo>(),"");
	}
	public IngredientInfoList(Collection<IngredientInfo> list,String foodName)
	{
		this.ingredientInfoList = list;
		this.foodName = foodName;
	}
	public Collection<IngredientInfo> getIngredientInfoList()
	{
		return this.ingredientInfoList;
	}
	public String getFoodName()
	{
		return this.foodName;
	}
	public void setIngredientInfoList(Collection<IngredientInfo> list)
	{
		this.ingredientInfoList = list;
	}
	public void setFoodName(String foodName)
	{
		this.foodName =foodName;
	}
	////add
	public IngredientInfo addIngredientInfoList(IngredientInfo ingredientInfo)
	{
		this.ingredientInfoList.add(ingredientInfo);
		return ingredientInfo;
	}
	////revise
	public IngredientInfo reviseIngredientInfoList(String ingredientCode,IngredientInfo changeingredientInfo)
	{
		int i=0;
		for(IngredientInfo ingred : ingredientInfoList)
		{
			if(ingred.getIngredientCode().equals(ingredientCode))
			{
				try
				{
					((LinkedList<IngredientInfo>)ingredientInfoList).set(i,changeingredientInfo);
					return ingred;
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
	//코드를 보내어 삭제
	public IngredientInfo removeIngredientInfoList(String ingredientCode)
	{
		IngredientInfo ingred = searchIngredientInfo(ingredientCode);
		if(ingred !=null)
		{
			this.ingredientInfoList.remove(ingred);
			return ingred;
		}
		return null;
	}
	//search
	public IngredientInfo searchIngredientInfo(String ingredientCode)
	{
		for(IngredientInfo ingred : ingredientInfoList)
		{
			if(ingred.getIngredientCode().equals(ingredientCode))
			{
				return ingred;
			}
		}
		return null;
	}
	public Collection<IngredientInfo> searchIngredientInfoList(String ingredientName)
	{
		LinkedList<IngredientInfo> list = new LinkedList<IngredientInfo>();
		for(IngredientInfo ingred : ingredientInfoList)
		{
			if(ingred.getIngredientName().equals(ingredientName))
			{
				list.add(ingred);	
			}
		}
		return list;
	}
}