import javax.swing.*;
import java.awt.event.*;

public class CancelListener implements ActionListener 
{
	JFrame frame;
	CancelListener(JFrame frame)
	{
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e)
	{
		frame.dispose();
	}
	
}
