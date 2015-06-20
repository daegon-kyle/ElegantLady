/*
이름 : 김대곤
class : LoginUI
상세설명 : 로그인화면
*/
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class  LoginUI
{
	private JTextField ID;							//아이디
	private JPasswordField password;			//비밀번호

	public LoginUI()
	{
		this(new JTextField(15), new JPasswordField(15));
	}
	public LoginUI(JTextField ID, JPasswordField password)
	{
		this.ID=ID;

		this.password=password;
	}
	public void showUI()
	{
		JFrame frame=new JFrame("요조숙녀");
		frame.setLocation(300, 150);
		frame.setSize(640, 420);
		Container cn=frame.getContentPane();
		JPanel panel=new JPanel(new BorderLayout());
		panel.setLayout(new GridBagLayout());
		panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		cn.add(BorderLayout.CENTER, panel);
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(5, 5, 5, 5);
		
		c.gridx=0;
		c.gridy=0;
		JLabel label1=new JLabel("아이디 :");
		panel.add(label1, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		JTextField ID=new JTextField(15);
		panel.add(ID, c);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label2=new JLabel("비밀번호 :");
		panel.add(label2, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		JPasswordField password=new JPasswordField(15);
		panel.add(password, c);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		JButton joinBu=new JButton("회원가입");
		panel.add(joinBu, c);
		c.gridx=3;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JButton loginBu=new JButton("로그인");
		panel.add(loginBu, c);
		
		//------------------------------ Listener ------------------------
		joinBu.addActionListener(new LoginJoinActionListener(joinBu));
		loginBu.addActionListener(new LoginActionListener(ID, password));
		cn.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
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
