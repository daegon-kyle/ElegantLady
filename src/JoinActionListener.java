/*
�̸� : ����
class : JoinActionListener
�󼼼��� : ȸ������ ��ư ������ �� ��й�ȣ Ȯ�� �� ȸ�������Ѵ�.
*/
import javax.swing.*;
import java.awt.event.*;
public class JoinActionListener implements ActionListener 
{
	private JFrame frame;						//ȭ��������
	private JTextField[] textArr;				//ȸ������ ��������
	private JPasswordField[] passArr;		//��й�ȣ, ��й�ȣȮ��
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
		//ȸ������ ��Ͽ� ����ֱ�
		//passwordField �迭, 0����� 1������ ������ �˻�, �ȵǸ� ȸ������ �ȵƴٴ� ǥ�� ��°� ȸ������ ���ϱ�
		if(!checkArea()) // ������ ��� �����ߴ��� Ȯ���Ѵ�. 
		{
			JOptionPane.showMessageDialog(null, "������ ��� �����Ͻÿ�.", "�Է¿���", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(!checkPassword()) //�� ��й�ȣ�� ���� ���� ���,
		{
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.", "��й�ȣ ����ġ", JOptionPane.ERROR_MESSAGE);
			return;
		}//ȸ������ ��ü�� ���� �� ȸ����Ͽ� �ֱ�
		if(!addMember())	//������ ���,
		{
			JOptionPane.showMessageDialog(null, "���̵� �̹� �����մϴ�. �ٸ� ���̵�� �Է����ּ���.", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else
		{
			exitJoin();			//ȸ������ ��ư ������ ���, ȭ�� ���� 
		}
		
	}
	public boolean checkPassword()
	{
		//JPassword[]�� ���� ���Ѵ�. �� ��й�ȣ�� �����ϸ� , true ��ȯ
		//������ ���, false ��ȯ
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

	public boolean checkArea()// ������ ��� �����ߴ��� Ȯ���Ѵ�.
	{
		for(int i=0; i<textArr.length; i++)
		{
			if(textArr[i].getText().equals(""))
				return false;
		//		JOptionPane.showMessageDialog(null, "������ ��� �����Ͻÿ�.", "�Է¿���", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public boolean addMember() 
	{
		//�߰��� ���, true ��ȯ
		//���̵���ȿ���˻�� ���⼭ checkController�� �����Ͽ� �˻�
		IdCheckController cControl=new IdCheckController(textArr[1].getText());
		if(cControl.verifyId())		//verifyId���� id�����ϴ� ���, ���� ��ȯ 
		{
			return false;
		}
		//ȸ�������� joinController
		//id �������� �ʴ� ���, �߰� ���ش�.
		MemberInfo memberInfo = new MemberInfo(textArr[0].getText(),textArr[1].getText(),new String(passArr[0].getPassword()),textArr[2].getText(),textArr[3].getText(),"");
		JoinDBController jControl=new JoinDBController(memberInfo);
		if(jControl.addMember())
		{
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����ϼ̽��ϴ�. �ݰ����ϴ�.^^", "ȸ������ ����", JOptionPane.INFORMATION_MESSAGE);
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
