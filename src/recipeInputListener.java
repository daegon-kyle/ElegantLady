//레시피 등록 리스너
import javax.swing.*;
import java.awt.event.*;

public class recipeInputListener implements ActionListener 
{
	private JFrame frame;					//프레임
	//음식정보
	private JTextField foodName;			//음식이름
	private JTextField foodCalorie;			//음식 칼로리
	private JTextField foodPhoto;			//음식사진(경로)	
	private JTextArea foodIntro;			//음식소개
		
	//조리정보
	private JTextField cookingTotalTime;	//총 조리시간
	private JTextField portion;				//분량
	private JComboBox<String> levelComboBox;//난이도
	private JTextField totalIngredient;		//재료개수
	private JTextArea tip;					//조리 팁	
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
			JOptionPane.showMessageDialog(null, "잘못된 값\n작성 내용을 다시 확인 하세요", "경고!", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	public void Register()throws NumberFormatException
	{
		/*file로 저장하는 컨트롤러
		RegisterController obj = new RegisterController( foodName, foodCalorie, foodPhoto, foodIntro,
		cookingTotalTime, portion, levelComboBox, totalIngredient, tip);	
		obj.register();
		*/
		/*database로 저장*/
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
