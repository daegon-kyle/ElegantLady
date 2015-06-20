import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
class MoneySrchBtnListener implements ActionListener 
{
	private JTextField txt1;
	private JTextField txt2;
	private JTable table;
	public MoneySrchBtnListener()
	{
		this(new JTextField(),new JTextField(),new JTable());
	}
	public MoneySrchBtnListener(JTextField txt1,JTextField txt2,JTable table)
	{
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.table = table;
	}
	public void actionPerformed(ActionEvent e)
	{
		
		Collection<FoodRecipeInfo> list = search(txt1.getText(),txt2.getText());
		String[] colNames = {"음식명","재료","소개","조리시간" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		for(FoodRecipeInfo foodRecipeInfo : list)
		{
			String foodName = foodRecipeInfo.getFoodInfo().getFoodName();
			String ingredients = "";
			for(RecipeIngreInfo recipeIngreInfo :foodRecipeInfo.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList())
			{
				ingredients += recipeIngreInfo.getIngredientName()+",";
			}
			String foodIntro = foodRecipeInfo.getFoodInfo().getFoodIntro();
			String time = Integer.toString(foodRecipeInfo.getRecipeInfo().getCookingTotalTime());

			String[] data = {foodName,ingredients,foodIntro,time};
			model.addRow(data);
		}
		table.setModel(model);
		
	}
	public Collection<FoodRecipeInfo> search(String money1,String money2)
	{
		MoneySrchController controller = new MoneySrchController(money1,money2);
		return controller.search();
	}

}