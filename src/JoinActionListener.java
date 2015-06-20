/*
이름 : 김대곤
class : JoinActionListener
상세설명 : 회원가입 버튼 눌렀을 시 비밀번호 확인 후 회원가입한다.
*/
import javax.swing.*;
import java.awt.event.*;
public class JoinActionListener implements ActionListener 
{
	private JFrame frame;						//화면프레임
	private JTextField[] textArr;				//회원가입 개인정보
	private JPasswordField[] passArr;		//비밀번호, 비밀번호확인
	public JoinActionListener()
	{
		this(new JFrame(), new JTextField[4], new JPasswordField[2]); 
	}
	public JoinActionListener(JFrame frame, JTextField[] textArr, JPasswordField[] passArr)
	{
		this.frame=frame;
		this.textArr=textArr;
		this.passArr=passArr;
	}
	public void actionPerformed(ActionEvent e)
	{
		//회원가입 목록에 집어넣기
		//passwordField 배열, 0번방과 1번방이 같은지 검사, 안되면 회원가입 안됐다는 표시 출력과 회원가입 못하기
		if(!checkArea()) // 정보를 모두 기입했는지 확인한다. 
		{
			JOptionPane.showMessageDialog(null, "정보를 모두 기입하시오.", "입력오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(!checkPassword()) //두 비밀번호가 같지 않은 경우,
		{
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 다시 입력해주세요.", "비밀번호 불일치", JOptionPane.ERROR_MESSAGE);
			return;
		}//회원정보 객체로 만든 후 회원목록에 넣기
		if(!addMember())	//실패한 경우,
		{
			JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다. 다른 아이디로 입력해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else
		{
			exitJoin();			//회원가입 버튼 눌렀을 경우, 화면 끄기 
		}
		
	}
	public boolean checkPassword()
	{
		//JPassword[]의 값을 비교한다. 두 비밀번호가 동일하면 , true 반환
		//거짓인 경우, false 반환
		System.out.println(passArr[0].getPassword());// + " " + passArr[1].getPassword());
		if(passArr[0].getPassword().length == passArr[1].getPassword().length)
		{
			for(int i=0; i<passArr[0].getPassword().length; i++)
			{
				if(passArr[0].getPassword()[i] != passArr[1].getPassword()[i])
					return false;
			}
			return true;
		}
		return false;
	}

	public boolean checkArea()// 정보를 모두 기입했는지 확인한다.
	{
		for(int i=0; i<textArr.length; i++)
		{
			if(textArr[i].getText().equals(""))
				return false;
		//		JOptionPane.showMessageDialog(null, "정보를 모두 기입하시오.", "입력오류", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public boolean addMember() 
	{
		//추가된 경우, true 반환
		//아이디유효성검사는 여기서 checkController를 생성하여 검사
		IdCheckController cControl=new IdCheckController(textArr[1].getText());
		if(cControl.verifyId())		//verifyId에서 id존재하는 경우, 참을 반환 
		{
			return false;
		}
		//회원가입은 joinController
		//id 존재하지 않는 경우, 추가 해준다.
		MemberInfo memberInfo = new MemberInfo(textArr[0].getText(),textArr[1].getText(),new String(passArr[0].getPassword()),textArr[2].getText(),textArr[3].getText(),"");
		JoinDBController jControl=new JoinDBController(memberInfo);
		if(jControl.addMember())
		{
			JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다. 반갑습니다.^^", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(MemberInfoList.getList().size());
			return true;
		}
		return false;
	}
	
	public void exitJoin()
	{
		frame.dispose();
	}
	public JTextField[] getTextArr()
	{
		return this.textArr;
	}
	public JPasswordField[] getPassArr()
	{
		return this.passArr;
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setTextArr(JTextField[] textArr)
	{
		this.textArr=textArr;
	}
	public void setPassArr(JPasswordField[] passArr)
	{
		this.passArr=passArr;
	}
}
