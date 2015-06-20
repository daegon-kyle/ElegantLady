/*
이름 : 김대곤
class : LoginJoinActionListener
상세설명 : 로그인에서 회원가입 버튼을 눌렀을 경우, 실행한다.
*/
import javax.swing.*;
import java.awt.event.*;
public class LoginJoinActionListener implements ActionListener 
{
	private JButton button;				//버튼(회원가입버튼)
	//단순히 회원가입으로 화면 넘기기
	public LoginJoinActionListener()
	{
		this(new JButton());
	}
	public LoginJoinActionListener(JButton button)
	{
		this.button=button;
	}

	public void actionPerformed(ActionEvent e)
	{
		moveJoinUI();
		//회원가입UI로 넘어가기
	}
	public void moveJoinUI()
	{
		JoinUI ui = new JoinUI();
		ui.showUI();
	}

	public JButton getButton()
	{
		return button;
	}
	public void setButton(JButton button)
	{
		this.button=button;
	}
}
