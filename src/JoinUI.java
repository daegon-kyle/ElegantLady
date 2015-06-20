/*
�̸� : ����
class : JoinUI
�󼼼��� : ȸ������ ȭ��
*/
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class  JoinUI
{
	private JTextField[] textArr;		//ȸ������ ��������
	private JPasswordField[] passArr;	//��й�ȣ, ��й�ȣȮ��

	public JoinUI()
	{
		this(new JTextField[4], new JPasswordField[2]);
	}
	public JoinUI(JTextField[] textArr, JPasswordField[] passArr)
	{
		this.textArr=textArr;
		this.passArr=passArr;
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
		c.insets=new Insets(2, 2, 2, 10);

		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label1=new JLabel("�̸�", SwingConstants.RIGHT);
		panel.add(label1, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		textArr[0]=new JTextField(18);
		panel.add(textArr[0], c);
		//=====================================
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label2=new JLabel("���̵�", SwingConstants.RIGHT);
		panel.add(label2, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		textArr[1]=new JTextField(18);
		panel.add(textArr[1], c);
		c.gridx=5;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JButton checkBu=new JButton("�ߺ��˻�");
		panel.add(checkBu, c);
		//=====================================
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label3=new JLabel("��й�ȣ", SwingConstants.RIGHT);
		panel.add(label3, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		passArr[0]=new JPasswordField(18);
		panel.add(passArr[0], c);
		//=====================================
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label4=new JLabel("��й�ȣ Ȯ��", SwingConstants.RIGHT);
		panel.add(label4, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		passArr[1]=new JPasswordField(18);
		panel.add(passArr[1], c);
		//=====================================
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label5=new JLabel("�ּ�", SwingConstants.RIGHT);
		panel.add(label5, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		textArr[2]=new JTextField(18);
		panel.add(textArr[2], c);
		//=====================================
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		JLabel label6=new JLabel("����ó", SwingConstants.RIGHT);
		panel.add(label6, c);
		c.gridx=2;
		c.gridwidth=3;
		c.fill=GridBagConstraints.HORIZONTAL;
		textArr[3]=new JTextField(18);
		panel.add(textArr[3], c);
		//=====================================
		c.gridx=2;
		c.gridy=7;
		c.gridwidth=1;
		JButton joinBu=new JButton("ȸ������");
		panel.add(joinBu, c);
		c.gridx=3;
		c.gridwidth=2;
		c.fill=GridBagConstraints.HORIZONTAL;
		JButton cancelBu=new JButton("���");
		panel.add(cancelBu, c);
		cn.add(panel, BorderLayout.CENTER);
		
		//�׼Ǹ�����
		checkBu.addActionListener(new CheckActionListener(textArr[1]));	//�ߺ��˻�
		joinBu.addActionListener(new JoinActionListener(frame, textArr, passArr));
		cancelBu.addActionListener(new CancelActionListener(frame));

		//
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	public JTextField[] getTextArr()
	{
		return this.textArr;
	}
	public JPasswordField[] getPassArr()
	{
		return this.passArr;
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
