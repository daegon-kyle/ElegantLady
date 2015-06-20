// 김대곤

public class FoodDTO
{
	private int foodCode;
	private String foodName;
	private String foodIntro;
	private String foodPhoto;
	private int foodCal;
	private String id;

	public FoodDTO()
	{
		this(0, "", "", "", 0, "");
	}
	public FoodDTO(int foodCode, String foodName, String foodIntro, String foodPhoto, int foodCal, String id)
	{
		this.foodCode=foodCode;
		this.foodName=foodName;
		this.foodIntro=foodIntro;
		this.foodPhoto=foodPhoto;
		this.foodCal=foodCal;
		this.id=id;
	}
	
	public int getFoodCode()
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
	public int getFoodCal()
	{ 
		return foodCal;
	}
	public String getId()
	{
		return id;
	}
	public void setFoodCode(int foodCode)
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
	public void setFoodCal(int foodCal)
	{
		this.foodCal=foodCal;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String toString()
	{
		return "음식코드:"+foodCode+" 음식이름:"+foodName+" 음식소개:"+foodIntro+" 음식사진경로:"+foodPhoto+" 음식열량:"+foodCal+" 작성자아이디:"+id;
	}
}
