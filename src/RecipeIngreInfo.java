/*
	작성자 : 장성봉
	클래스명 : RecipeIngreInfo
*/
public class  RecipeIngreInfo
{
	private String ingredientName;
	private String ingredientCode;
	private int ingredientNum;
	public RecipeIngreInfo()
	{
		this("","",0);
	}
	public RecipeIngreInfo(String ingredientName,String ingredientCode,int ingredientNum)
	{
		this.ingredientName =ingredientName;
		this.ingredientCode =ingredientCode;
		this.ingredientNum =ingredientNum;
	}
	public String getIngredientName()
	{
		return this.ingredientName;
	}
	public String getIngredientCode()
	{
		return this.ingredientCode;
	}
	public int getIngredientNum()
	{
		return this.ingredientNum;
	}
	public void setIngredientName(String ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientCode(String ingredientCode)
	{
		this.ingredientCode =ingredientCode;
	}
	public void setIngredientNum(int ingredientNum)
	{
		this.ingredientNum = ingredientNum;
	}
}
