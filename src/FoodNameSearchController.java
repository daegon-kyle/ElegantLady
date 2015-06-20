//  @ Date : 2014/4/29
//  @ Author : 박홍근
// 음식명으로 음식검색
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
		JOptionPane.showMessageDialog(null,"검색결과가 존재하지 않습니다.다시 입력해 주세요.","검색결과",JOptionPane.ERROR_MESSAGE);
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
