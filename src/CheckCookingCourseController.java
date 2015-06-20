//양진영
import javax.swing.*;
public class CheckCookingCourseController 
{
	private String foodCode;
	private int step;
	
	public CheckCookingCourseController()
	{
		this("",0);
	}
	public CheckCookingCourseController(String foodCode,int step)
	{
		this.foodCode=foodCode;
		this.step=step;
	}
	public int getStep()
	{
		return step;
	}
	public String getFoodCode()
	{
		return foodCode;
	}
	public CookingCourseList searchFood()
	{
		CookingCourseList tmp=FoodRecipeInfoList.searchFoodRecipeInfo(foodCode).getRecipeInfo().getCookingCourseList();
		if (tmp==null)
			return new CookingCourseList();	//음식못찾는경우
		else
			return tmp;
	}
	public boolean checkStep(CookingCourseList tmp)
	{
		if(tmp.getCookingCourseList().size()<step)
		{
			return false;
		}
		else if(0>step)
		{
			return false;
		}
		return true;
	}
	public String[] searchCookingCourse()
	{
		CookingCourseList tmp=searchFood();
		checkStep(tmp);
		CookingCourse tmp2=tmp.searchCookingCourse(step);
		String[] result=new String[4];
		if(tmp2==null)
		{
			JOptionPane.showMessageDialog(null, "과정이 존재하지 않습니다.", "과정오류", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		else
		{
			String time=Integer.toString(tmp2.getCookingTime());
			result[0]=time;
			result[1]=tmp2.getCookingPhoto();
			result[2]=tmp2.getCookingInst();
			result[3]=Integer.toString(step);
			return result;
		}
	}
}
