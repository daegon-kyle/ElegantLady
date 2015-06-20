/*
�̸� : ����
class : CancelActionListener
�󼼼��� : ȸ������ �Ϸ��� �Ҷ� �α����� ����ϴ� Ŭ����
*/
import javax.swing.*;
import java.awt.event.*;
public class CancelActionListener implements ActionListener 
{
	private JFrame frame;			//������

	public CancelActionListener()
	{
		this(new JFrame());
	}
	public CancelActionListener(JFrame frame)
	{
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e)
	{
		frame.dispose();
	}

	public JFrame getFrame()
	{
		return this.frame;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
}
