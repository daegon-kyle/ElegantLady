//±è´ë°ï
import java.util.*;

public class FoodList
{
	private Collection<FoodDTO> foodList;
	
	public FoodList()
	{
		this(new LinkedList<FoodDTO>());
	}
	public FoodList(Collection<FoodDTO> foodList)
	{
		this.foodList=foodList;
	}
	
	public FoodDTO addFoodList(FoodDTO foodDTO)
	{
		foodList.add(foodDTO);
		return foodDTO;
	}
	public FoodDTO removeFoodList(FoodDTO foodDTO)
	{
		if(foodList.contains(foodDTO))
		{
			foodList.remove(foodDTO);
			return foodDTO;
		}
		return null;
	}
	public FoodDTO reviseFoodList(FoodDTO exFoodDTO, FoodDTO newFoodDTO)
	{
		for (FoodDTO tmp : foodList)
		{
			if(tmp.getFoodCode()==exFoodDTO.getFoodCode())
			{
				foodList.remove(exFoodDTO);
				foodList.add(newFoodDTO);
				return newFoodDTO;
			}
		}
		return null;
	}
	public FoodDTO searchFoodList(FoodDTO foodDTO)
	{
		for (FoodDTO tmp : foodList)
		{
			if(tmp.getFoodCode()==foodDTO.getFoodCode())
			{
				return tmp;
			}
		}
		return null;
	}
	public Collection<FoodDTO> getFoodList()
	{
		return foodList;
	}
	public void setFoodList(Collection<FoodDTO> foodList)
	{
		this.foodList=foodList;
	}
}
