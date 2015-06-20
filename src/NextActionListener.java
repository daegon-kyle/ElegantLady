import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NextActionListener implements ActionListener 
{
	private JFrame frame;
	private String foodCode;
	private int step;
	public NextActionListener()
	{
		this(null,"",1);
	}
	public NextActionListener(JFrame frame,String foodCode,int step)
	{
		this.foodCode=foodCode;
		this.step=step;
		this.frame=frame;
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public String getFoodCode()
	{
		return foodCode;
	}
	public int getStep()
	{
		return step;
	}
	public void setFrame(JFrame frame)
	{
		this.frame=frame;
	}
	public void setStep(int step)
	{
		this.step=step;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}public int calcHour(int time)
	{
		return time/3600;
	}
	public int calcMin(int time)
	{
		int min=time/60;
		if(min>=60)
		{
			min=min%60;
		}
		return min;
	}
	public int calcSec(int time)
	{
		return time%60; 
	}
	public void showUI(int time,String path,String description,int step)
	{
		CookingCourseUI cooking=new CookingCourseUI(Integer.toString(calcHour(time)),
			Integer.toString(calcMin(time)),Integer.toString(calcSec(time)),"00",path,description,step,foodCode);
		cooking.showUI();
	}
	public void actionPerformed(ActionEvent e)
	{
		search();
	}
	public void search()
	{
		String[] tmp;
		CheckCookingCourseController c=new CheckCookingCourseController(foodCode,++step);
		//System.out.println(1);
		tmp=c.searchCookingCourse();
		
		//시간(초),사진,설명,단계
		if(tmp!=null)
		{
			showUI(Integer.parseInt(tmp[0]),tmp[1],tmp[2],Integer.parseInt(tmp[3]));//컨트롤러에서 시간(초),사진,설명,단계를 읽어와야한다.)
			frame.dispose();
		}
		else
		{
			//오류메시지.
		}
	}
}
