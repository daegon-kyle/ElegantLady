import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
class IngredSrchBtnListener implements ActionListener
{
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;
	public IngredSrchBtnListener()
	{
		this(new JTextField(),new JTextField(),new JTextField(), new JTable());
	}
	public IngredSrchBtnListener(JTextField txt1,JTextField txt2,JTextField txt3,JTable table)
	{
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.txt3 = txt3;
		this.table = table;
	}
	public void setTxt1(JTextField txt1) { this.txt1 = txt1; }
	public void setTxt2(JTextField txt2) { this.txt2 = txt2; }
	public void setTxt3(JTextField txt3) { this.txt3 = txt3; }
	public void setTable(JTable table) { this.table = table; }
	public JTextField getTxt1() { return txt1; }
	public JTextField getTxt2() { return txt2; }
	public JTextField getTxt3() { return txt3; }
	public JTable getTable() { return table; }

	public void actionPerformed(ActionEvent e)
	{
		
		Collection<FoodRecipeInfo> list = search(txt1.getText(),txt2.getText(),txt3.getText());
		DefaultTableModel model = new DefaultTableModel();
		String[] colNames = {"음식명","재료","소개","조리시간" };
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
	public Collection<FoodRecipeInfo> search(String ingred1, String ingred2, String ingred3)
	{
		IngredSrchController controller = new IngredSrchController(ingred1,ingred2,ingred3);
		return controller.search();
	}

}
