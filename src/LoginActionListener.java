/*
이름 : 김대곤
class : LoginActionListener
상세설명 : 아이디와 비밀번호 입력 후, 로그인을 하는 리스너
*/
import javax.swing.*;
import java.awt.event.*;
public class LoginActionListener implements ActionListener 
{
	private JTextField ID;					//아이디
	private JPasswordField password;	 //비밀번호

	public LoginActionListener()
	{
		this(new JTextField(15), new JPasswordField(15));
	}
	public LoginActionListener(JTextField ID, JPasswordField password)
	{
		this.ID=ID;
		this.password=password;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(checkMember())			//아이디와 비밀번호 체크하는 메소드
		{
			showUI();
			JOptionPane.showMessageDialog(null, "반갑습니다. 요조숙녀입니다.^^.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		return;
	}
	public boolean checkMember()		//아이디와 비밀번호 체크하는 메소드
	{
		String pass=String.valueOf(password.getPassword());					//getPassword는 char[]을 반환패므로 valueOf를 이용하여 stirng으로 변환해준다.
		LoginContorller control=new LoginContorller(ID.getText(), pass);
		if(control.acceptLogin()!=null)
			return true;
		return false;
	}
	public void showUI()
	{
		MainFrameUI mainFrame=new MainFrameUI(); 
		mainFrame.showUI();
	}
	public JTextField getID()
	{
		return ID;
	}
	public JPasswordField getPassword()
	{
		return password;
	}
	public void setID(JTextField ID)
	{
		this.ID=ID;
	}
	public void setPassword(JPasswordField password)
	{
		this.password=password;
	}
}
