//양진영
//재료주문버튼리스너
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OrderActionListener implements ActionListener 
{
	private String foodCode;
	public OrderActionListener()
	{
		this("");
	}
	public OrderActionListener(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public String getFoodCode()
	{
		return this.foodCode;
	}
	public void setButton(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public void actionPerformed(ActionEvent e)
	{
		searchStore();
	}
	public void searchStore()
	{
		OrderIngredController oic=new OrderIngredController(foodCode);
		OrderIngredientUI ui=new OrderIngredientUI(oic.searchFoodName(),oic.searchStoreName(),oic.searchRecipeIngredList(),oic.searchRecipeIngredList());
		ui.showUI();
	}
}
