// 김대곤

public class IngredientDTO
{
	private int ingredientCode;
	private String ingredientName;
	private String unit;

	public IngredientDTO()
	{
		this(0, "", "");
	}
	
	public IngredientDTO(int ingredientCode, String ingredientName, String unit)
	{
		this.ingredientCode=ingredientCode;
		this.ingredientName=ingredientName;
		this.unit=unit;
	}
	
	public int getIngredientCode()
	{
		return ingredientCode;
	}
	public String getIngredientName()
	{
		return ingredientName;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setIngredientCode(int ingredientCode)
	{
		this.ingredientCode=ingredientCode;
	}
	public void setIngredientName(String ingredientName)
	{
		this.ingredientName=ingredientName;
	}
	public void setUnit(String unit)
	{
		this.unit=unit;
	}
	public String toString()
	{
		return "재료코드:"+ingredientCode+" 재료이름:"+ingredientName+" 단위:"+unit;
	}
}
