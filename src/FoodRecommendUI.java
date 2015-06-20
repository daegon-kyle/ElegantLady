import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
class FoodRecommendUI 
{
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private Object[][] data; 
	public FoodRecommendUI() {
		this(new Object[0][0]);
	} 
	public FoodRecommendUI(Object[][] data){
		frame = new JFrame();
		button1 = new JButton("재료검색");
		button2 = new JButton("가격대검색");
		this.data = data;
	}

	public void setFrame(JFrame frame){
		this.frame = frame;
	}
	public JFrame getFrame() { return this.frame; }

	public void setButton1(JButton button1) { this.button1 = button1; }
	public JButton getButton1() { return this.button1; }

	public void setButton2(JButton button2) { this.button2 = button2; }
	public JButton getButton2() { return this.button2; }

	public void setData(Object[][] data) { this.data = data; }
	public Object[][] getData() { return this.data; } 

	public void showUI(){

		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(new LineBorder(Color.BLACK,1,true));
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20,10,20,10);
		c.gridx = 0; 
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(button1,c);

		c.gridx = 0; 
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(button2,c);
		contentPane.add(panel,BorderLayout.WEST);

		button1.setBackground(new Color(0.6f,0.9f,0.0f));
		button2.setBackground(new Color(0.6f,0.9f,0.0f));
///////////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(new LineBorder(Color.BLACK,1,true));
///////////////////////////////////////////////////////////////////
		JPanel searchPanel = new JPanel(); //		
		JLabel lb1 = new JLabel("재료1");
		JTextField txt1 = new JTextField(5);
		JLabel lb2 = new JLabel("재료2");
		JTextField txt2 = new JTextField(5);
		JLabel lb3 = new JLabel("재료3");
		JTextField txt3 = new JTextField(5);
		JButton searchButton = new JButton("검색");

		searchPanel.add(lb1);
		searchPanel.add(txt1);
		searchPanel.add(lb2);
		searchPanel.add(txt2);
		searchPanel.add(lb3);
		searchPanel.add(txt3);
		searchPanel.add(searchButton);
///////////////////////////////////////////////////////
		panel2.add(searchPanel,BorderLayout.NORTH);
	//	panel2.add(new JLabel());

		String colNames[] = {"음식명","재료","소개","조리시간" };
		JTable table = new JTable(data,colNames);
		JScrollPane scrollPane = new JScrollPane(table);
		panel2.add(scrollPane,BorderLayout.CENTER);
		
		
		contentPane.add(panel2,BorderLayout.CENTER);
		
		ActionListener lst1 = new IngredSrchActionListener(frame,panel2,data,button1,button2);
		button1.addActionListener(lst1);

		ActionListener lst2 = new MoneySrchActionListener(frame,panel2,data,button1,button2);
		button2.addActionListener(lst2);
		
		ActionListener lst3 = new IngredSrchBtnListener(txt1,txt2,txt3,table);
		searchButton.addActionListener(lst3);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
		
}
