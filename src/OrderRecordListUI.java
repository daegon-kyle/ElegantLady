//�ֹ�����Ȯ�� ȭ��
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
public class OrderRecordListUI 
{
	private JFrame frame;			//������
	private JTextField orderName;	//�ֹ��� �̸�
	private JTextField orderPhone;	//�ֹ��� ����ó
	private JTextField recipientName;//������ �̸�
	private JTextField recipientPhone;//������ ����ó
	private JTextField recipientAddress;//������ �ּ�
	private JTextField orderCode;	//����ڵ�
	private JTextField orderTime;	//��۽ð�
	private JTable table;			//��ǰ���� ���̺�
	private Object[] colNames;		//Ÿ��Ʋ
	private Object[][] data;		//����	

	public OrderRecordListUI()
	{
		this("ȫ�浿","010-1111-1111","�̼���","010-1212-3434","���󳲵� �뿵","D1111","02:00~06:00",
			new String[]{"����1","����2","����3","����4","����5","����6","����7","����8"},
			new int[]{5,4,6,3,6,9,6,4},
			new double[]{1000,1500,2000,3500,4000,10000,12323,123123}
		);
	}
	public OrderRecordListUI(String orderName,String orderPhone,String recipientName,String recipientPhone,String recipientAddress,
		String orderCode,String orderTime,String[] ingredient,int[] ingredientNum,double[] ingredientValue)
	{
		this.frame = new JFrame("�ֹ�����Ȯ��");
		this.orderName = new JTextField(orderName);
		this.orderPhone = new JTextField(orderPhone);
		this.recipientName = new JTextField(recipientName);
		this.recipientPhone = new JTextField(recipientPhone);
		this.recipientAddress = new JTextField(recipientAddress);
		this.orderCode = new JTextField(orderCode);
		this.orderTime = new JTextField(orderTime);
		//���̺�
		colNames = new Object[]{"����","����","����"};
		data = new Object[ingredient.length][3];		
		for(int i =0 ; i< ingredient.length; i++)
		{
			data[i][0] = ingredient[i];
			data[i][1] = ingredientNum[i];
			data[i][2] = ingredientValue[i];
		}
		this.table = new JTable(data,colNames);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int cnt = 0; cnt < tcm.getColumnCount(); cnt++)
		{
			tcm.getColumn(cnt).setCellRenderer(dtcr);
		}
	}
	//���� ����
	public Container createContentPane()
	{
		//Container�غ�
		Container contentPane = frame.getContentPane();			//�������� contentPane������
		
		JPanel BasicPanel = new JPanel(new GridLayout(3,1));	//�����г�
		//�ֹ��� ����
		JPanel orderInfoPanel = new JPanel(new GridLayout(2,1)); //�����гο� ���� �ֹ��� ���� �г�
		orderInfoPanel.setBorder(new TitledBorder("�ֹ��� ����"));
		JPanel panel1 = new JPanel(new GridLayout(1,2));
		panel1.add(new JLabel("�ֹ��� �̸� :"));
		panel1.add(orderName);
		panel1.add(new JLabel(""));
		panel1.add(new JLabel(""));
		panel1.add(new JLabel(""));
		JPanel panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(new JLabel("�ֹ��� ����ó :"));
		panel2.add(orderPhone);
		panel2.add(new JLabel(""));
		panel2.add(new JLabel(""));
		panel2.add(new JLabel(""));
		orderInfoPanel.add(panel1);
		orderInfoPanel.add(panel2);

		//������ ����
		JPanel recipientInfoPanel = new JPanel(new GridLayout(3,1));//�����гο� ���� ������ ���� �г�
		recipientInfoPanel.setBorder(new TitledBorder("������ ����"));
		JPanel panel3 = new JPanel(new GridLayout(1,2));
		panel3.add(new JLabel("������ �̸� :"));
		panel3.add(recipientName);
		panel3.add(new JLabel(""));
		panel3.add(new JLabel(""));
		panel3.add(new JLabel(""));
		JPanel panel4 = new JPanel(new GridLayout(1,2));
		panel4.add(new JLabel("������ ����ó :"));
		panel4.add(recipientPhone);
		panel4.add(new JLabel(""));
		panel4.add(new JLabel(""));
		panel4.add(new JLabel(""));
		JPanel panel5 = new JPanel(new GridLayout(1,2));
		panel5.add(new JLabel("������ �ּ� :"));
		panel5.add(recipientAddress);
		panel5.add(new JLabel(""));
		panel5.add(new JLabel(""));
		panel5.add(new JLabel(""));
		recipientInfoPanel.add(panel3);
		recipientInfoPanel.add(panel4);
		recipientInfoPanel.add(panel5);
		//��� ����
		JScrollPane scrollPaneTable = new JScrollPane(table);
		scrollPaneTable.setBorder(new TitledBorder("�������"));
		//�ݱ��ư 
		JPanel panel6 = new JPanel(new FlowLayout());
		JButton closeButton =  new JButton("�ݱ�");
		closeButton.addActionListener(new CancelActionListener(frame));
		panel6.add(closeButton);
		BasicPanel.add(orderInfoPanel);
		BasicPanel.add(recipientInfoPanel);
		BasicPanel.add(scrollPaneTable);
		
		contentPane.add(BasicPanel,BorderLayout.CENTER);
		contentPane.add(panel6,BorderLayout.SOUTH);
		return contentPane;
	}
	public void showUI()
	{
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		frame.pack();
		frame.setVisible(true);
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public JTextField getOrderName()
	{
		return this.orderName;
	}
	public JTextField getOrderPhone()
	{
		return this.orderPhone;
	}
	public JTextField getRecipientName()
	{
		return this.recipientName;
	}
	public JTextField getRecipientPhone()
	{
		return this.recipientPhone;
	}
	public JTextField getRecipientAddress()
	{
		return this.recipientAddress;
	}
	public JTextField getOrderCode()
	{
		return this.orderCode;
	}
	public JTextField getOrderTime()
	{
		return this.orderTime;
	}
	public JTable getTable()
	{
		return this.table;
	}
	public Object[] getColNames()
	{
		return this.colNames;
	}
	public Object[][] getData()
	{
		return this.data;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setOrderName(JTextField orderName)
	{
		this.orderName = orderName;
	}
	public void setOrderPhone(JTextField orderPhone)
	{
		this.orderPhone =orderPhone;
	}
	public void setRecipientName(JTextField recipientName)
	{
		this.recipientName = recipientName;
	}
	public void setRecipientPhone(JTextField recipientPhone)
	{
		this.recipientPhone =recipientPhone;
	}
	public void setRecipientAddress(JTextField recipientAddress)
	{
		this.recipientAddress=recipientAddress;
	}
	public void setOrderCode(JTextField orderCode)
	{
		this.orderCode =orderCode;
	}
	public void setOrderTime(JTextField orderTime)
	{
		this.orderTime = orderTime;
	}
	public void setTable(JTable table)
	{
		this.table= table;
	}
	public void setColNames(Object[] colNames)
	{
		this.colNames = colNames;
	}
	public void setData(Object[][] data)
	{
		this.data = data;
	}
}
