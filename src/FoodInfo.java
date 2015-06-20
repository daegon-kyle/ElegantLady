//양진영
//음식정보
public class FoodInfo
{
	private String foodCode;
	private String foodName;
	private String foodIntro;
	private String foodPhoto;
	private int foodCalorie;
	
	public FoodInfo()
	{
		this("","","","",0);
	}
	public FoodInfo(String foodName,String foodIntro,String foodPhoto,int foodCalorie)
	{
		this(Integer.toString((FoodRecipeInfoList.getFoodRecipeInfoList().size())),foodName,foodIntro,foodPhoto,foodCalorie);
		//static완료되야 성공
	}
	public FoodInfo(String foodCode,String foodName,String foodIntro,String foodPhoto,int foodCalorie)
	{
		this.foodCode=foodCode;
		this.foodName=foodName;
		this.foodIntro=foodIntro;
		this.foodPhoto=foodPhoto;
		this.foodCalorie=foodCalorie;
	}
	public String getFoodCode()
	{
		return foodCode;
	}
	public String getFoodName()
	{
		return foodName;
	}
	public String getFoodIntro()
	{
		return foodIntro;
	}
	public String getFoodPhoto()
	{
		return foodPhoto;
	}
	public int getFoodCalorie()
	{
		return foodCalorie;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public void setFoodName(String foodName)
	{
		this.foodName=foodName;
	}
	public void setFoodIntro(String foodIntro)
	{
		this.foodIntro=foodIntro;
	}
	public void setFoodPhoto(String foodPhoto)
	{
		this.foodPhoto=foodPhoto;
	}
	public void setFoodCalorie(int foodCalorie)
	{
		this.foodCalorie=foodCalorie;
	}
}  
