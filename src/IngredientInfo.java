/*
	작성자 : 장성봉
	클래스명 : IngredientInfo
*/
public class  IngredientInfo
{
	private String ingredientName;
	private String ingredientCode;
	private String unit;
	public IngredientInfo()
	{
		this("","","");
	}
	public IngredientInfo(String ingredientName, String ingredientCode,String unit)
	{
		this.ingredientName = ingredientName;
		this.ingredientCode= ingredientCode;
		this.unit =unit;
	}
	public IngredientInfo(String ingredientName, String ingredientCode)
	{
		this(ingredientName,ingredientCode,"개");
		
	}
	public IngredientInfo(String ingredientCode)
	{
		this("",ingredientCode,"개");
	}
	
	public String getIngredientName()
	{
		return this.ingredientName;
	}
	public String getIngredientCode()
	{
		return this.ingredientCode;
	}
	public String getUnit()
	{
		return this.unit;
	}
	public void setIngredientName(String ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientCode( String ingredientCode)
	{
		this.ingredientCode= ingredientCode;
	}
	public void setUnit(String unit)
	{
		this.unit =unit;
	}
}
