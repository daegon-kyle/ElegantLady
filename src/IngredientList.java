//±è´ë°ï
import java.util.*;

public class IngredientList
{
	private Collection<IngredientDTO> ingredientList;
	
	public IngredientList()
	{
		this(new LinkedList<IngredientDTO>());
	}
	public IngredientList(Collection<IngredientDTO> ingredientList)
	{
		this.ingredientList=ingredientList;
	}
	
	public IngredientDTO addIngredientList(IngredientDTO ingredientDTO)
	{
		ingredientList.add(ingredientDTO);
		return ingredientDTO;
	}
	public IngredientDTO removeIngredientList(IngredientDTO ingredientDTO)
	{
		if(ingredientList.contains(ingredientDTO))
		{
			ingredientList.remove(ingredientDTO);
			return ingredientDTO;
		}
		return null;
	}
	public IngredientDTO reviseIngredientList(IngredientDTO exIngredientDTO, IngredientDTO newIngredientDTO)
	{
		for (IngredientDTO tmp : ingredientList)
		{
			if(tmp.getIngredientCode()==exIngredientDTO.getIngredientCode())
			{
				ingredientList.remove(exIngredientDTO);
				ingredientList.add(newIngredientDTO);
				return newIngredientDTO;
			}
		}
		return null;
	}
	public IngredientDTO searchIngredientList(IngredientDTO ingredientDTO)
	{
		for (IngredientDTO tmp : ingredientList)
		{
			if(tmp.getIngredientCode()==ingredientDTO.getIngredientCode())
			{
				return tmp;
			}
		}
		return null;
	}
	public Collection<IngredientDTO> getIngredientList()
	{
		return ingredientList;
	}
	public void setIngredientList(Collection<IngredientDTO> ingredientList)
	{
		this.ingredientList=ingredientList;
	}
}
