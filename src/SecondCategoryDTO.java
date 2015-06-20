// 김대곤

public class SecondCategoryDTO
{
	private int secondCategoryCode;
	private String secondCategoryName;
	private int firstCategoryCode;

	public SecondCategoryDTO()
	{
		this(0, "", 0);
	}
	public SecondCategoryDTO(int secondCategoryCode, String secondCategoryName, int firstCategoryCode)
	{
		this.secondCategoryCode=secondCategoryCode;
		this.secondCategoryName=secondCategoryName;
		this.firstCategoryCode=firstCategoryCode;
	}
	
	public int getSecondCategoryCode()
	{
		return secondCategoryCode;
	}
	public String getSecondCategoryName()
	{
		return secondCategoryName;
	}
	public int getFirstCategoryCode()
	{
		return firstCategoryCode;
	}
	public void setSecondCategoryCode(int secondCategoryCode)
	{
		this.secondCategoryCode=secondCategoryCode;
	}
	public void setSecondCategoryName(String secondCategoryName)
	{
		this.secondCategoryName=secondCategoryName;
	}
	public void setFirstCategoryCode(int firstCategoryCode)
	{
		this.firstCategoryCode=firstCategoryCode;
	}
	public String toString()
	{
		return "2차카테고리코드:"+secondCategoryCode+" 2차카테고리명:"+secondCategoryName+" 1차카테고리코드:"+firstCategoryCode;
	}
}
