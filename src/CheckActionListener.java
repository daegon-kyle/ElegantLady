/*
�̸� : ����
class : CheckActionListener
�󼼼��� : ȸ�����Խ� ���̵� �ߺ��˻�
*/
import javax.swing.*;
import java.awt.event.*;
public class  CheckActionListener implements ActionListener
{
	private JTextField text;		//�Է��� ���̵�

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
		//���̵���ȿ���˻��ϱ�
		IdCheckController control=new IdCheckController(text.getText());
		//�ɼ�-��ȿ�� �˻� ��, ������ ��� ������ â �����Բ��Ѵ�.������ �˾� �Ǵ� ���̺� ������ �Ѵ�.
		//ID�����ϴ� ���, �� ��ȯ
		if(control.verifyId())
		{
			JOptionPane.showMessageDialog(null, "���̵� �̹� �����մϴ�. �ٸ� ���̵�� �Է����ּ���.", "���̵� �ߺ�", JOptionPane.ERROR_MESSAGE);
			return;				
		}
		else if(text.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "���̵� �ߺ�", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.", "���̵� �ߺ�", JOptionPane.INFORMATION_MESSAGE );
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
