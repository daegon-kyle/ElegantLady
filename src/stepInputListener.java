//�������� ������� ��ư
import javax.swing.*;
import java.awt.event.*;

public class stepInputListener implements ActionListener 
{
	private JFrame frame;
	public stepInputListener()
	{				
		this(new JFrame("�����������"));
	}
	public stepInputListener(JFrame frame)
	{
		this.frame =frame;
	}
	public void actionPerformed(ActionEvent e)
	{		
		RecipeCourseUI obj = new RecipeCourseUI();
		obj.showUI();		
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public void setframe(JFrame frame)
	{
		this.frame = frame;
	}
	
}
