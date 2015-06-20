/*
	
	Class : CategorySearchActionListener
*/

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class CategorySearchActionListener implements ActionListener 
{
	private JFrame frame;
	private JTextField text;
	private JScrollPane scrollPane;
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	static boolean what=true;
	public CategorySearchActionListener()
	{
		this(new JFrame(),new JComboBox<String>(),new JComboBox<String>(),  new JScrollPane());
	}
	public CategorySearchActionListener(JFrame frame, JComboBox<String> combo1,JComboBox<String> combo2, JScrollPane scrollPane)
	{
		this.frame=frame;
		this.combo1 = combo1;
		this.combo2 = combo2;
		this.scrollPane=scrollPane;
	}
	//���ĸ�Ͽ��� ���ϴ� ������ ã�ƿ��� �޼ҵ� �ʿ�
	//�ϴ� actionPerformed�� �־�ξ���
	public void actionPerformed(ActionEvent e)    
	{
		showResult();
	}
	public void showResult() //���ǿ� �´� ����� �޾ƿͼ� ������ֱ�
	{

		//������� text�� ������� �˻��� �Է�
		//text �̿��Ͽ� ���ĸ�Ͽ��� ���ǿ� �´� ���İ� ���� ��������
		int num=10;	//���ǿ� �´� ���� ����
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(num, 1));	//JScroll�� �� ���� ū �г�
		JButton[] foodBu=new JButton[num];		//���İ����� �´� ��ư �迭 ����
		frame.getContentPane().remove(panel2);
		frame.repaint();
		JLabel[] foodLa=new JLabel[8];	 //		���̺�8, ���ĸ�, ���, �����ð�, �ǰ�����
		//=======================================
		if(what){
		for (int cnt=0; cnt<2; cnt++)	//���߿� Collection �޾ƿͼ� ����for��
		{
			JPanel panel3=new JPanel(new GridLayout(1,2));					//������ ���� ���� ���� �г�
			JPanel panel4=new JPanel();													//���� ���� �г�
			JPanel panel5=new JPanel(new GridLayout(4, 2));					//���� ���� ���� �г�
			//�����ڵ尪�� �̸� �޾Ƽ� String���� ��ȯ �� button ������ �߰�
			foodBu[cnt]=new JButton(new Integer(cnt).toString(),new ImageIcon("1.jpg"));		//�����ڵ尪�� ��ΰ�
			foodBu[cnt].setPreferredSize(new Dimension(200, 200));
			foodLa[0]=new JLabel("�丮�� : ", SwingConstants.CENTER);
			foodLa[1]=new JLabel("¥���", SwingConstants.CENTER);		//���߿��� �� �޾ƿ���;
			foodLa[2]=new JLabel("��� : ", SwingConstants.CENTER);;
			foodLa[3]=new JLabel("���", SwingConstants.CENTER);			//���߿��� �� �޾ƿ���;
			foodLa[4]=new JLabel("�����ð�: ", SwingConstants.CENTER);;
			foodLa[5]=new JLabel("30��", SwingConstants.CENTER);		 //���߿��� �� �޾ƿ���
			foodLa[6]=new JLabel("�ǰ�����: ", SwingConstants.CENTER);
			foodLa[7]=new JLabel("��", SwingConstants.CENTER);		   //���߿��� �� �޾ƿ���;

			//���� �г� �ֱ�
			panel4.add(foodBu[cnt]);
			panel5.add(foodLa[0]);
			panel5.add(foodLa[1]);
			panel5.add(foodLa[2]);
			panel5.add(foodLa[3]);
			panel5.add(foodLa[4]);
			panel5.add(foodLa[5]);
			panel5.add(foodLa[6]);
			panel5.add(foodLa[7]);
			panel3.add(panel4);
			panel3.add(panel5);
			panel2.add(panel3);
			foodBu[cnt].addActionListener(new PhotoActionListener(new Integer(cnt).toString())); //�ڵ尪 �ѱ��
		}
		scrollPane.setViewportView(panel2);
		//=======================================
		what=false;
		}
		else{
		//=======================================������ �͵�, �׳� ��ȭ�� �׸��� ��µ� �� �ִٴ� �� �����ش�.
		//layout �ֱ� ...........................6=>9, 7=>10, 8=>11
		JPanel tempPanel=new JPanel();
		tempPanel.add(new JLabel("  "));
		scrollPane.setViewportView(tempPanel);
		JPanel panel9=new JPanel(new GridLayout(1,2));
		JButton  imageIcon3=new JButton(new ImageIcon("2.jpg"));
		imageIcon3.setPreferredSize(new Dimension(200, 200));
		JPanel panel10=new JPanel();
		JPanel panel11=new JPanel(new GridLayout(4, 2));
		panel10.add(imageIcon3);
		JLabel labelS17=new JLabel("�丮�� : ", SwingConstants.CENTER);
		JLabel labelS18=new JLabel("������", SwingConstants.CENTER);  //���߿��� �� �޾ƿ���
		JLabel labelS19=new JLabel("��� : ", SwingConstants.CENTER);
		JLabel labelS20=new JLabel("���", SwingConstants.CENTER);  //���߿��� �� �޾ƿ���
		JLabel labelS21=new JLabel("�����ð�: ", SwingConstants.CENTER);
		JLabel labelS22=new JLabel("30��", SwingConstants.CENTER);  //���߿��� �� �޾ƿ���
		JLabel labelS23=new JLabel("�ǰ�����: ", SwingConstants.CENTER);
		JLabel labelS24=new JLabel("��", SwingConstants.CENTER);  //���߿��� �� �޾ƿ���
		panel11.add(labelS17);
		panel11.add(labelS18);
		panel11.add(labelS19);
		panel11.add(labelS20);
		panel11.add(labelS21);
		panel11.add(labelS22);
		panel11.add(labelS23);
		panel11.add(labelS24);
		panel9.add(panel10);
		panel9.add(panel11);
		panel2.add(panel9);
		scrollPane.setViewportView(panel2);
		}
	}
}
