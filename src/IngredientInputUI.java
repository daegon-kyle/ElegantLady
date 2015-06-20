//��� ��� ui
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class IngredientInputUI 
{
	private JFrame frame;				//������
	private JLabel recipeName;			//�丮��
	private JTextField ingredientTotalNum;	//����� �� ����
	private JTextField[] ingredientName;	//��� �迭	
	private JTextField[] ingredientNum;		//���� �迭
	public IngredientInputUI()
	{
		this("�丮��",4);
	}
	public IngredientInputUI(String recipeName,int ingredientTotalNum)
	{
		this.frame = new JFrame("��� ���");
		this.recipeName = new JLabel(recipeName);
		this.ingredientTotalNum = new JTextField(Integer.toString(ingredientTotalNum));
		this.ingredientName = new JTextField[ingredientTotalNum];
		this.ingredientNum = new JTextField[ingredientTotalNum];
		for(int cnt = 0; cnt < ingredientTotalNum; cnt++)
		{
			this.ingredientName[cnt] = new JTextField("");
			this.ingredientName[cnt].setPreferredSize(new Dimension(100,25));
			this.ingredientNum[cnt] = new JTextField("1");
			this.ingredientNum[cnt].setPreferredSize(new Dimension(100,25));
		}
	}
	//���� ����
	public Container createContentPane()
	{
		//Container�غ�
		Container contentPane = frame.getContentPane();		//�������� contentPane������
		JPanel panel1 = new JPanel(new GridLayout(ingredientName.length,1));//��ũ�ѿ� ���� �г�
		JPanel[] panel2 = new JPanel[ingredientName.length];		//��ũ�ѿ� ���� �г��� ����
		JPanel panel3 = new JPanel();						//��ư �ִ� �г�		

		//panel2����
		for(int cnt = 0; cnt < ingredientName.length ; cnt++)
		{
			panel2[cnt] = new JPanel(new FlowLayout());			
			panel2[cnt].add(new JLabel("	"));
			panel2[cnt].add(new JLabel("���"+(cnt+1)));
			panel2[cnt].add(new JLabel(" "));
			panel2[cnt].add(new JLabel("���� : "));
			panel2[cnt].add(ingredientName[cnt]);
			panel2[cnt].add(new JLabel("				"));
			panel2[cnt].add(new JLabel("��  �� : "));	
			panel2[cnt].add(ingredientNum[cnt]);
			panel2[cnt].add(new JLabel("��(g)"));
			panel2[cnt].add(new JLabel("				"));
		}
		//panel1�� panel2����
		for(int cnt= 0; cnt < ingredientName.length; cnt++)
		{
			panel1.add(panel2[cnt]);
		}
		//��ư����
		JButton ingredientRegisterButton = new JButton("��� ����ϱ�");
		ingredientRegisterButton.addActionListener(
			new IngredientRegisterListener(frame,recipeName,ingredientTotalNum,ingredientName,ingredientNum));
		JButton cancelButton = new JButton("���ư���");
		cancelButton.addActionListener(new CancelActionListener(frame));
		//panel3 ���� (��ư ��)
		panel3.add(ingredientRegisterButton,BorderLayout.NORTH);
		panel3.add(cancelButton,BorderLayout.NORTH);
		panel3.setBorder(new TitledBorder(""));
		//��ġ��		
		JScrollPane basicScrollPane =  new JScrollPane(panel1);
		basicScrollPane.setBorder(new TitledBorder(new LineBorder(Color.red),recipeName.getText()));
		contentPane.add(basicScrollPane,BorderLayout.CENTER);
		contentPane.add(panel3,BorderLayout.SOUTH);
		return contentPane;
	}
	//ui����
	public void showUI()
	{
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		frame.pack();
		frame.setVisible(true);
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setRecipeName(JLabel recipeName)
	{
		this.recipeName =recipeName;
	}
	public void setIngredientTotalNum(JTextField ingredientTotalNum)
	{
		this.ingredientTotalNum =ingredientTotalNum;
	}
	public void setIngredientName(JTextField[] ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientNum(JTextField[] ingredientNum)
	{
		this.ingredientNum =ingredientNum;
	}
	public JFrame getFrame()
	{
		return this.frame;		
	}
	public JLabel getRecipeName()
	{
		return this.recipeName;		
	}
	public JTextField getIngredientTotalNum()
	{
		return this.ingredientTotalNum;
	}
	public JTextField[] getIngredientName()
	{
		return this.ingredientName;
	}
	public JTextField[] getIngredientNum()
	{
		return this.ingredientNum;
	}
}
