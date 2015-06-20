/*
이름 : 김대곤
class : PhotoActionListener
상세설명 : 사진 버튼 눌렀을 경우, 음식 설명 보여준다.
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class  PhotoActionListener implements ActionListener
{
	private String text;						//음식코드				
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
	public void moveUI()  //음식설명해주는 화면으로 이동 
	{
		PhotoController control=new PhotoController(text);
		FoodRecipeInfo foodRecipeInfo=control.verifyFoodCode();
		//존재하지 않은 경우, 조건문을 사용하겠지만 위 경우 무조건 존재하므로 별도의 리턴값이 필요없다.
		//if(foodInfo==null)
		//	return;
		//음식, 음식객체로 foodInfoUI 생성한다.각각의 필요정보는 음식이름, 재료, 조리시간, 경로
		String str="";
		for (RecipeIngreInfo recipeIngreInfo : (((LinkedList<RecipeIngreInfo>) (foodRecipeInfo.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) )))
		{
			str+=recipeIngreInfo.getIngredientName()+",";
		}

		FoodInfoUI temp=new FoodInfoUI(foodRecipeInfo.getFoodInfo().getFoodName(), str, foodRecipeInfo.getRecipeInfo().getCookingTotalTime() ,foodRecipeInfo.getFoodInfo().getFoodIntro(), foodRecipeInfo.getFoodInfo().getFoodPhoto(), foodRecipeInfo.getFoodInfo().getFoodCode());	//임시로 ui생성 후 뿌려준다.
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
