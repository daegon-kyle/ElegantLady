//  @ Date : 2014/4/29
//  @ Author : 김대곤
// 키워드값으로 음식검색
//
import java.util.*;
import javax.swing.*;
public class TodayController
{
	private String foodName;

	public TodayController()
	{
		this("");
	}
	public TodayController(String foodName)
	{
		this.foodName=foodName;
	}
	
	public Collection<FoodRecipeInfo> verifyFoodName()
	{
		LinkedList<FoodRecipeInfo> list=(LinkedList<FoodRecipeInfo>)(FoodRecipeInfoList.searchTodayFood((foodName.subSequence(0, 1)).toString()));	//subsequence (0,1)인 경우, char배열이므로 맨 첫번째 문자만 리턴한다.
		if(list.size()!=0)
			return list;
		JOptionPane.showMessageDialog(null,"검색결과가 존재하지 않습니다. 다시 입력해 주세요.","검색결과",JOptionPane.ERROR_MESSAGE);
		return list;					//주의.................................................
	}
	
	public String getFoodName()
	{
		return foodName;
	}
	public void setFoodCode(String foodName)
	{
		this.foodName=foodName;
	}
}
