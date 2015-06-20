//  @ Date : 2014/4/29
//  @ Author : ����
// �����ڵ忡 �´� ������ ������ ���� ��ȯ�Ѵ�.

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
		FoodRecipeInfo tmp=FoodRecipeInfoList.searchFoodRecipeInfo(foodCode);	//�̳��� ����
		if(tmp!=null)					//�����ϴ� ���, �߰��� ���������� ����
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
