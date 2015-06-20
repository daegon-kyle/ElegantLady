//±è´ë°ï
import java.util.*;

public class SecondCategoryList
{
	private Collection<SecondCategoryDTO> secondCategoryList;

	public SecondCategoryList()
	{
		this(new LinkedList<SecondCategoryDTO>());
	}
	public SecondCategoryList(Collection<SecondCategoryDTO> secondCategoryList)
	{
		this.secondCategoryList=secondCategoryList;
	}
	
	public SecondCategoryDTO addSecondCategoryList(SecondCategoryDTO secondCategoryDTO)
	{
		secondCategoryList.add(secondCategoryDTO);
		return secondCategoryDTO;
	}
	public SecondCategoryDTO removeSecondCategoryList(SecondCategoryDTO secondCategoryDTO)
	{
		if(secondCategoryList.contains(secondCategoryDTO))
		{
			secondCategoryList.remove(secondCategoryDTO);
			return secondCategoryDTO;
		}
		return null;
	}
	public SecondCategoryDTO reviseSecondCategoryList(SecondCategoryDTO exSecondCategoryDTO, SecondCategoryDTO newSecondCategoryDTO)
	{
		for (SecondCategoryDTO tmp : secondCategoryList)
		{
			if(tmp.getSecondCategoryCode()==exSecondCategoryDTO.getSecondCategoryCode())
			{
				secondCategoryList.remove(exSecondCategoryDTO);
				secondCategoryList.add(newSecondCategoryDTO);
				return newSecondCategoryDTO;
			}
		}
		return null;
	}
	public SecondCategoryDTO searchSecondCategoryList(SecondCategoryDTO secondCategoryDTO)
	{
		for (SecondCategoryDTO tmp : secondCategoryList)
		{
			if(tmp.getSecondCategoryCode()==secondCategoryDTO.getSecondCategoryCode())
			{
				return tmp;
			}
		}
		return null;
	}
	public Collection<SecondCategoryDTO> getSecondCategoryList()
	{
		return secondCategoryList;
	}
	public void setSecondCategoryList(Collection<SecondCategoryDTO> secondCategoryList)
	{
		this.secondCategoryList=secondCategoryList;
	}
}
