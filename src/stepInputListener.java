//조리과정 등록으로 버튼
import javax.swing.*;
import java.awt.event.*;

public class stepInputListener implements ActionListener 
{
	private JFrame frame;
	public stepInputListener()
	{				
		this(new JFrame("조리과정등록"));
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
