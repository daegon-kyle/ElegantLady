/*
이름 : 김대곤
class : CheckActionListener
상세설명 : 회원가입시 아이디 중복검사
*/
import javax.swing.*;
import java.awt.event.*;
public class  CheckActionListener implements ActionListener
{
	private JTextField text;		//입력한 아이디

	public CheckActionListener()
	{
		this(new JTextField());
	}
	public CheckActionListener(JTextField text)
	{
		this.text=text;
	}
	public void actionPerformed(ActionEvent e)
	{
		check();
	}
	public void check()
	{
		//아이디유효성검사하기
		IdCheckController control=new IdCheckController(text.getText());
		//옵션-유효성 검사 후, 실패의 경우 별도의 창 나오게끔한다.조금한 팝업 또는 레이블 나오게 한다.
		//ID존재하는 경우, 참 반환
		if(control.verifyId())
		{
			JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다. 다른 아이디로 입력해주세요.", "아이디 중복", JOptionPane.ERROR_MESSAGE);
			return;				
		}
		else if(text.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "아이디 중복", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.", "아이디 중복", JOptionPane.INFORMATION_MESSAGE );
		}

	}
	public JTextField getText()
	{
		return text;
	}
	public void setText(JTextField text)
	{
		this.text=text;
	}
}
