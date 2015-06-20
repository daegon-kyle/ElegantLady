import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
class MoneySrchActionListener implements ActionListener
{
	private JFrame frame;
	private JPanel panel;
	private Object[][] data; 
	private JButton button1;
	private JButton button2;
	public MoneySrchActionListener() {}
	public MoneySrchActionListener(JFrame frame, JPanel panel, Object[][]data, JButton button1, JButton button2) {
		this.frame = frame; 
		this.panel = panel; 
		this.data = data;
		this.button1 = button1;
		this.button2 = button2;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
	public JFrame getFrame() { return this.frame; }
	
	public void setPanel(JPanel panel) { this.panel = panel; }
	public JPanel getPanel() { return panel; }
	
	public void setData(Object[][] data) { this.data = data; }
	public Object[][] getData() { return this.data; } 

	public void setButton1(JButton button1) { this.button1 = button1; }
	public JButton getButton1() { return this.button1; }

	public void setButton2(JButton button2) { this.button2 = button2; }
	public JButton getButton2() { return this.button2; }
	public void actionPerformed(ActionEvent e)
	{
		showUI();
	}
	public void showUI()
	{
		frame.getContentPane().removeAll();
		/////////////////////////////////////
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
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(new LineBorder(Color.BLACK,1,true));		
///////////////////////////////////////////////////////
		JPanel searchPanel = new JPanel(); //
		searchPanel.setLayout(new GridBagLayout());

		c.insets = new Insets(2,2,2,2);
		c.gridx = 0;
		c.gridy = 0;
		JLabel label = new JLabel("가격대");
		searchPanel.add(label,c);

		c.gridx = 1;
		c.gridy = 0;
		JTextField field1 = new JTextField(7);
		searchPanel.add(field1,c);

		c.gridx = 2;
		c.gridy = 0;
		JLabel label2 = new JLabel("~");
		searchPanel.add(label2,c);
		
		c.gridx = 3;
		c.gridy = 0;
		JTextField field2 = new JTextField(7);
		searchPanel.add(field2,c);
		
		c.gridx = 4;
		c.gridy = 0;
		JButton searchButton = new JButton("검색");
		searchPanel.add(searchButton,c);
///////////////////////////////////////////////////////
		panel2.add(searchPanel,BorderLayout.NORTH);

		String colNames[] = {"음식명","재료","소개","조리시간" };
		JTable table = new JTable(data,colNames);
		JScrollPane scrollPane = new JScrollPane(table);
		panel2.add(scrollPane,BorderLayout.CENTER);	
		
		frame.getContentPane().add(panel2,BorderLayout.CENTER);

		ActionListener lst = new MoneySrchBtnListener(field1,field2,table);
		searchButton.addActionListener(lst);

	//	frame.repaint();
		frame.setVisible(true);
	}

}
