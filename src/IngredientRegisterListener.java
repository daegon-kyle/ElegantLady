//������ϱ��ư ������
import javax.swing.*;
import java.awt.event.*;

public class IngredientRegisterListener implements ActionListener 
{
	private JFrame frame;				//������
	private JLabel recipeName;			//�丮��
	private JTextField ingredientTotalNum;	//����� �� ����
	private JTextField[] ingredientName;	//��� �迭	
	private JTextField[] ingredientNum;		//���� �迭
	public IngredientRegisterListener(JFrame frame,JLabel recipeName,JTextField ingredientTotalNum,JTextField[] ingredientName,JTextField[] ingredientNum)
	{
		this.frame= frame;
		this.recipeName = recipeName;
		this.ingredientTotalNum =ingredientTotalNum;
		this.ingredientName = ingredientName;
		this.ingredientNum = ingredientNum;		
	}
	public void actionPerformed(ActionEvent e)
	{
		ingredientRegister();
		frame.dispose();
	}	
	public void ingredientRegister()
	{
		IngredientRegisterController obj = new IngredientRegisterController(recipeName,ingredientTotalNum,ingredientName,ingredientNum);
		obj.register();
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setRecipeName(JLabel recipeName)
	{
		this.recipeName =recipeName;
	}
	public void setIngredientTotalNum(JTextField ingredientTotalNum)
	{
		this.ingredientTotalNum =ingredientTotalNum;
	}
	public void setIngredientName(JTextField[] ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientNum(JTextField[] ingredientNum)
	{
		this.ingredientNum =ingredientNum;
	}
	public JFrame getFrame()
	{
		return this.frame;		
	}
	public JLabel getRecipeName()
	{
		return this.recipeName;		
	}
	public JTextField getIngredientTotalNum()
	{
		return this.ingredientTotalNum;
	}
	public JTextField[] getIngredientName()
	{
		return this.ingredientName;
	}
	public JTextField[] getIngredientNum()
	{
		return this.ingredientNum;
	}
}