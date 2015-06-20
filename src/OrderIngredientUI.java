import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class  OrderIngredientUI
{
	private JFrame frame;						//������
	private JLabel recipiName;					//�������̸�
	private JCheckBox[] checkBox;				//üũ�ڽ�
	private JComboBox<String> comboBox1;		//���� ���� �޺��ڽ�
	private JComboBox<String> comboBox2;		//��۽ð� ���� �޺��ڽ�
	private JSpinner[] spinner;					//���ǳ�
	//private SpinnerNumberModel[] ingredientNum;	//���ǳ� ����
	//������
	OrderIngredientUI()
	{
		this("�������̸�",new String[]{"�����","�̼���","û����"},
			new String[]{"12:00~01:00","02:00~06:00","06:00~08:00"},
			new String[]{"���1","���2","���3","���4","���5","���6","���7","���8","���9","���10","���11","���12"});
	}
	//�����ε�� ������
	OrderIngredientUI(String recipiName,String[] store,String[] storeTime,String[] ingredient)
	{
		this.frame = new JFrame("����ֹ�");			//������ 			
		this.recipiName = new JLabel(recipiName);	//������ �̸� 	
		//üũ�ڽ�
		this.checkBox = new JCheckBox[ingredient.length];//üũ�ڽ�
		for(int cnt = 0; cnt <ingredient.length; cnt++ )//������ üũ�ڽ� 
		{
			checkBox[cnt] = new JCheckBox(ingredient[cnt],false);
		}
		//�޺��ڽ�
		this.comboBox1=new JComboBox<String>();		//�Ǹ�ó �޺��ڽ�
		this.comboBox1.setModel(new DefaultComboBoxModel<String>(store));//�޺��ڽ� ����
		this.comboBox2=new JComboBox<String>();		//��۽ð� �޺��ڽ�
		this.comboBox2.setModel(new DefaultComboBoxModel<String>(storeTime));
		//���ǳ� 
		SpinnerNumberModel[] ingredientNum = new SpinnerNumberModel[ingredient.length];		//���ǳ��� ����
		for(int cnt = 0; cnt < ingredient.length;cnt++)										//������ ���ǳ��� ���� ����
		{
			ingredientNum[cnt] = new SpinnerNumberModel(1, 1, null, 1);						//�ʱⰪ, �ּҰ�, �ִ밪, �ܰ�
		}
		this.spinner = new JSpinner[ingredient.length];
		for(int cnt = 0; cnt < ingredient.length;cnt++)
		{
			spinner[cnt]= new JSpinner();
			spinner[cnt].setModel(ingredientNum[cnt]);
		}
	}
	//���� ����
	public Container createContentPane()
	{
		//Container�غ�
		Container contentPane = frame.getContentPane();		//�������� contentPane������
		//�г� ����
		JPanel panel1 = new JPanel(new BorderLayout());		//��ϰ�, ���弱��, ��۽ð��� �ִ� ū �г�
		JPanel panel2 = new JPanel(new GridLayout(checkBox.length,1));//��ũ�ѿ� ���� �г�
		JPanel panel3 = new JPanel();						//���� ����,��۽ð��� �ִ� �г�
		JPanel panel4 = new JPanel();						//�ֹ�, ���ư���
		
		//----------------- listener ------------------------------------------------
		JButton button1 = new JButton("�ֹ��ϱ�");
		button1.addActionListener(new OrderListener());
		JButton button2 = new JButton("���ư���");
		button2.addActionListener(new CancelActionListener(frame));
		

		JPanel[] panel5 = new JPanel[checkBox.length];		//����, ����,�� ���� �г�
		//panel5����
		for(int cnt = 0; cnt < checkBox.length ; cnt++)
		{
			panel5[cnt] = new JPanel(new GridLayout(1,3));			//flow / grid(1,3)			
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel(""));			
			panel5[cnt].add(checkBox[cnt]);
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel("����"));			
			panel5[cnt].add(spinner[cnt]);
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel(""));
		}
		//panel2�� panel5����
		for(int cnt= 0; cnt < checkBox.length; cnt++)
		{
			panel2.add(panel5[cnt]);
		}
		//scrollpane�� panel2����
		JScrollPane scrollPane = new JScrollPane(panel2);
		//panel3����
		panel3.add(new JLabel("���弱��"));	//���弱��
		panel3.add(this.comboBox1);
		panel3.add(new JLabel(""));
		panel3.add(new JLabel("��۽ð�"));
		panel3.add(this.comboBox2);
		//panel1���� (scrollPane,panel3��)
		panel1.add(scrollPane,BorderLayout.CENTER);
		panel1.add(panel3,BorderLayout.SOUTH);
		panel1.setBorder(new TitledBorder(recipiName.getText()));
		//panel4 ���� (panel1,panel3��)
		panel4.add(button1,BorderLayout.NORTH);
		panel4.add(button2,BorderLayout.NORTH);
		panel4.setBorder(new TitledBorder(""));
		
		contentPane.add(panel1,BorderLayout.CENTER);
		contentPane.add(panel4,BorderLayout.SOUTH);			

		return contentPane;
	}
	//ui����
	public void showUI()
	{
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		frame.pack();
		frame.setVisible(true);
	}
}

 
    