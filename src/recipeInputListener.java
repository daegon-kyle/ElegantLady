//������ ��� ������
import javax.swing.*;
import java.awt.event.*;

public class recipeInputListener implements ActionListener 
{
	private JFrame frame;					//������
	//��������
	private JTextField foodName;			//�����̸�
	private JTextField foodCalorie;			//���� Į�θ�
	private JTextField foodPhoto;			//���Ļ���(���)	
	private JTextArea foodIntro;			//���ļҰ�
		
	//��������
	private JTextField cookingTotalTime;	//�� �����ð�
	private JTextField portion;				//�з�
	private JComboBox<String> levelComboBox;//���̵�
	private JTextField totalIngredient;		//��ᰳ��
	private JTextArea tip;					//���� ��	
	public recipeInputListener(JFrame frame,JTextField foodName,JTextField foodCalorie,JTextField foodPhoto,JTextArea foodIntro,
		JTextField cookingTotalTime,JTextField portion,JComboBox<String> levelComboBox,JTextField totalIngredient,JTextArea tip)
	{
		this.frame =frame;
		this.foodName= foodName;
		this.foodCalorie= foodCalorie;
		this.foodPhoto =foodPhoto;
		this.foodIntro =foodIntro;
		this.cookingTotalTime =cookingTotalTime;
		this.portion =portion;
		this.levelComboBox =levelComboBox;
		this.totalIngredient =totalIngredient;
		this.tip=tip; 
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Register();
			frame.dispose();		
		}
		catch (NumberFormatException a)
		{
			JOptionPane.showMessageDialog(null, "�߸��� ��\n�ۼ� ������ �ٽ� Ȯ�� �ϼ���", "���!", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	public void Register()throws NumberFormatException
	{
		/*file�� �����ϴ� ��Ʈ�ѷ�
		RegisterController obj = new RegisterController( foodName, foodCalorie, foodPhoto, foodIntro,
		cookingTotalTime, portion, levelComboBox, totalIngredient, tip);	
		obj.register();
		*/
		/*database�� ����*/
		RegisterDBController obj = new RegisterDBController( foodName, foodCalorie, foodPhoto, foodIntro,
		cookingTotalTime, portion, levelComboBox, totalIngredient, tip);	
		obj.register();
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public JTextField getFoodName()
	{
		return this.foodName;
	}
	public JTextField getFoodCalorie()
	{
		return this.foodCalorie;
	}
	public JTextField getFoodPhoto()
	{
		return this.foodPhoto;
	}
	public JTextArea getFoodIntro()
	{
		return this.foodIntro;
	}		
	public JTextField getCookingTotalTime()
	{
		return this.cookingTotalTime;
	}
	public JTextField getPortion()
	{
		return this.portion;
	}
	public JComboBox<String> getLevelComboBox()
	{
		return this.levelComboBox;
	}
	public JTextField getTotalIngredient()
	{
		return this.totalIngredient;
	}
	public JTextArea getTip()
	{
		return this.tip;
	}
	public void setFrame(JFrame frame)
	{
		this.frame =frame;
	}
	public void setFoodName(JTextField foodName)
	{
		this.foodName = foodName;
	}
	public void setFoodCalorie(JTextField foodCalorie)
	{
		this.foodCalorie = foodCalorie;
	}
	public void setFoodPhoto(JTextField foodPhoto)
	{
		this.foodPhoto =foodPhoto;
	}
	public void setFoodIntro(JTextArea foodIntro)
	{
		this.foodIntro =foodIntro;
	}		
	public void setCookingTotalTime(JTextField cookingTotalTime)
	{
		this.cookingTotalTime =cookingTotalTime;
	}
	public void setPorton(JTextField porton)
	{
		this.portion = portion;
	}
	public void setLevelComboBox(JComboBox<String> levelComboBox)
	{
		this.levelComboBox = levelComboBox;
	}
	public void setTotalIngredient(JTextField totalIngredient)
	{
		this.totalIngredient =totalIngredient;
	}
	public void setTip(JTextArea tip)
	{
		this.tip =tip;
	}
}
