/*
�̸� : ����
class : LoginJoinActionListener
�󼼼��� : �α��ο��� ȸ������ ��ư�� ������ ���, �����Ѵ�.
*/
import javax.swing.*;
import java.awt.event.*;
public class LoginJoinActionListener implements ActionListener 
{
	private JButton button;				//��ư(ȸ�����Թ�ư)
	//�ܼ��� ȸ���������� ȭ�� �ѱ��
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
		//ȸ������UI�� �Ѿ��
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
