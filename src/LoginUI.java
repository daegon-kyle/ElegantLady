/*
�̸� : ����
class : LoginUI
�󼼼��� : �α���ȭ��
*/
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class  LoginUI
{
	private JTextField ID;							//���̵�
	private JPasswordField password;			//��й�ȣ

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
		JFrame frame=new JFrame("��������");
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
		JLabel label1=new JLabel("���̵� :");
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
		JLabel label2=new JLabel("��й�ȣ :");
		panel.add(label2, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		JPasswordField password=new JPasswordField(15);
		panel.add(password, c);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		JButton joinBu=new JButton("ȸ������");
		panel.add(joinBu, c);
		c.gridx=3;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JButton loginBu=new JButton("�α���");
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
