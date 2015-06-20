
//재료등록화면으로 이동 리스너
import javax.swing.*;
import java.awt.event.*;

public class ingredientButtonListener implements ActionListener 
{
	private JFrame frame;
	private JTextField recipeName;
	private JTextField ingredientTotalNum;
	public ingredientButtonListener(JFrame frame,JTextField recipeName,JTextField ingredientTotalNum)
	{
		this.frame= frame;
		this.recipeName = recipeName;
		this.ingredientTotalNum = ingredientTotalNum;
	}
	public void actionPerformed(ActionEvent e)
	{		
		int num;
		try
		{
			num= Integer.parseInt(ingredientTotalNum.getText());
			IngredientInputUI obj = new IngredientInputUI(recipeName.getText(),num);
			obj.showUI();
		}
		catch (NumberFormatException a)
		{
			JOptionPane.showMessageDialog(null, "잘못된 재료의 수!\n작성 내용을 다시 확인 하세요", "경고!", JOptionPane.ERROR_MESSAGE);
		}			
	}
	public JTextField getRecipeName()
	{
		return this.recipeName;
	}
	public JTextField getIngredientTotalNum()
	{
		return this.ingredientTotalNum;
	}
	public void setRecipeName(JTextField recipeName)
	{
		this.recipeName =recipeName;
	}
	public void setIngredientTotalNum(JTextField ingredientTotalNum)
	{
		this.ingredientTotalNum =ingredientTotalNum;
	}
}
