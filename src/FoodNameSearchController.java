//  @ Date : 2014/4/29
//  @ Author : ��ȫ��
// ���ĸ����� ���İ˻�
//  FoodNameSearchController

import java.util.*;
import javax.swing.*;
public class FoodNameSearchController
{
	private String foodName;

	public FoodNameSearchController()
	{
		this("");
	}
	public FoodNameSearchController(String foodName)
	{
		this.foodName=foodName;
	}
	
	public Collection<FoodRecipeInfo> compareName()
	{
		LinkedList<FoodRecipeInfo> list=(LinkedList<FoodRecipeInfo>)(FoodRecipeInfoList.searchFoodRecipeInfoList(foodName));
		if(list.size()!=0)
			return list;
		JOptionPane.showMessageDialog(null,"�˻������ �������� �ʽ��ϴ�.�ٽ� �Է��� �ּ���.","�˻����",JOptionPane.ERROR_MESSAGE);
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
