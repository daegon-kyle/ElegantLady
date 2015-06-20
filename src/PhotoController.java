//  @ Date : 2014/4/29
//  @ Author : 김대곤
// 음식코드에 맞는 음식을 가지고 오고 반환한다.

public class PhotoController
{
	private String foodCode;

	public PhotoController()
	{
		this("");
	}
	public PhotoController(String foodCode)
	{
		this.foodCode=foodCode;
	}
	
	public FoodRecipeInfo verifyFoodCode()
	{
		FoodRecipeInfo tmp=FoodRecipeInfoList.searchFoodRecipeInfo(foodCode);	//이놈이 문제
		if(tmp!=null)					//존재하는 경우, 발견한 음식조리법 리턴
		{
			return tmp;
		}
		return null;
	}
	
	public String getFoodCode()
	{
		return foodCode;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
}
