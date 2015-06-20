//  @ Date : 2014/4/29
//  @ Author : ����
// Ű���尪���� ���İ˻�
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
		LinkedList<FoodRecipeInfo> list=(LinkedList<FoodRecipeInfo>)(FoodRecipeInfoList.searchTodayFood((foodName.subSequence(0, 1)).toString()));	//subsequence (0,1)�� ���, char�迭�̹Ƿ� �� ù��° ���ڸ� �����Ѵ�.
		if(list.size()!=0)
			return list;
		JOptionPane.showMessageDialog(null,"�˻������ �������� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.","�˻����",JOptionPane.ERROR_MESSAGE);
		return list;					//����.................................................
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
