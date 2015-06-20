/*
이름 : 김대곤
class : CancelActionListener
상세설명 : 회원가입 하려고 할때 로그인을 취소하는 클래스
*/
import javax.swing.*;
import java.awt.event.*;
public class CancelActionListener implements ActionListener 
{
	private JFrame frame;			//프레임

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
