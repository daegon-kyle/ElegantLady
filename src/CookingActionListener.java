//������
//�丮���۹�ư ������
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CookingActionListener implements ActionListener
{
	private JFrame frame;
	private String foodCode;
	public CookingActionListener()
	{
		this(new JFrame(),"");
	}
	public CookingActionListener(JFrame frmae,String foodCode)
	{
		this.foodCode=foodCode;
		this.frame=frame;
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public String getFoodCode()
	{
		return this.foodCode;
	}
	public void setFrame(JFrame frame)
	{
		this.frame=frame;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public int calcHour(int time)
	{
		System.out.println("hour"+time/3600);
		return time/3600;
	}
	public int calcMin(int time)
	{
		int min=time/60;
		if(min>=60)
		{
			min=min%60;
		}
		System.out.println("Min"+min);
		return min;
	}
	public int calcSec(int time)
	{
		System.out.println("sec"+time%60);
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
		CheckCookingCourseController c=new CheckCookingCourseController(foodCode,0);
		tmp=c.searchCookingCourse();
		//�ð�(��),����,����,�ܰ�
		if(tmp!=null)
		{
			showUI(Integer.parseInt(tmp[0]),tmp[1],tmp[2],Integer.parseInt(tmp[3]));//��Ʈ�ѷ����� �ð�(��),����,����,�ܰ踦 �о�;��Ѵ�.)
		//	frame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "������ ã�� �� �����ϴ�.", "���", JOptionPane.ERROR_MESSAGE);
			//�����޽���.
		}
	}
}
