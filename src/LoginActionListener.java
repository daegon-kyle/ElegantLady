/*
�̸� : ����
class : LoginActionListener
�󼼼��� : ���̵�� ��й�ȣ �Է� ��, �α����� �ϴ� ������
*/
import javax.swing.*;
import java.awt.event.*;
public class LoginActionListener implements ActionListener 
{
	private JTextField ID;					//���̵�
	private JPasswordField password;	 //��й�ȣ

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
		if(checkMember())			//���̵�� ��й�ȣ üũ�ϴ� �޼ҵ�
		{
			showUI();
			JOptionPane.showMessageDialog(null, "�ݰ����ϴ�. ���������Դϴ�.^^.", "�α��� ����", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "�α��� ����", JOptionPane.ERROR_MESSAGE);
		return;
	}
	public boolean checkMember()		//���̵�� ��й�ȣ üũ�ϴ� �޼ҵ�
	{
		String pass=String.valueOf(password.getPassword());					//getPassword�� char[]�� ��ȯ�йǷ� valueOf�� �̿��Ͽ� stirng���� ��ȯ���ش�.
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
