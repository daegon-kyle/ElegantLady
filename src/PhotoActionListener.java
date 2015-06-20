/*
�̸� : ����
class : PhotoActionListener
�󼼼��� : ���� ��ư ������ ���, ���� ���� �����ش�.
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class  PhotoActionListener implements ActionListener
{
	private String text;						//�����ڵ�				
	public PhotoActionListener()
	{
		this(new String(""));
	}
	public PhotoActionListener(String text)
	{
		this.text=text;
	}
	public void actionPerformed(ActionEvent e)
	{
		moveUI();
	}
	public void moveUI()  //���ļ������ִ� ȭ������ �̵� 
	{
		PhotoController control=new PhotoController(text);
		FoodRecipeInfo foodRecipeInfo=control.verifyFoodCode();
		//�������� ���� ���, ���ǹ��� ����ϰ����� �� ��� ������ �����ϹǷ� ������ ���ϰ��� �ʿ����.
		//if(foodInfo==null)
		//	return;
		//����, ���İ�ü�� foodInfoUI �����Ѵ�.������ �ʿ������� �����̸�, ���, �����ð�, ���
		String str="";
		for (RecipeIngreInfo recipeIngreInfo : (((LinkedList<RecipeIngreInfo>) (foodRecipeInfo.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) )))
		{
			str+=recipeIngreInfo.getIngredientName()+",";
		}

		FoodInfoUI temp=new FoodInfoUI(foodRecipeInfo.getFoodInfo().getFoodName(), str, foodRecipeInfo.getRecipeInfo().getCookingTotalTime() ,foodRecipeInfo.getFoodInfo().getFoodIntro(), foodRecipeInfo.getFoodInfo().getFoodPhoto(), foodRecipeInfo.getFoodInfo().getFoodCode());	//�ӽ÷� ui���� �� �ѷ��ش�.
		temp.showUI();
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text=text;
	}
}
