import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class  EndButtonListener implements ActionListener
{
	private JFrame frame;
	public EndButtonListener() 
	{
		this(new JFrame());
	}
	public EndButtonListener(JFrame frame)
	{
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e)
	{
		frame.dispose();
	}	
}
