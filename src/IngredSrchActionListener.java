import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
class IngredSrchActionListener implements ActionListener 
{
	private JFrame frame;
	private JPanel panel;
	private Object[][] data; 
	private JButton button1;
	private JButton button2;
	public IngredSrchActionListener(JFrame frame, JPanel panel, Object[][]data, JButton button1, JButton button2) {
		this.frame = frame; 
		this.panel = panel; 
		this.data = data;
		this.button1 = button1;
		this.button2 = button2;
	}
	public void actionPerformed(ActionEvent e){
		frame.getContentPane().removeAll();
	//	frame.repaint();
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
//////////////////////////////////////////////
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

		String colNames[] = {"음식명","재료","소개","조리시간" };
		JTable table = new JTable(data,colNames);
		JScrollPane scrollPane = new JScrollPane(table);
		panel2.add(scrollPane,BorderLayout.CENTER);
				
		frame.getContentPane().add(panel2,BorderLayout.CENTER);

		ActionListener lst = new IngredSrchBtnListener(txt1,txt2,txt3,table);
		searchButton.addActionListener(lst);
//		frame.repaint();
		frame.setVisible(true);
	}
}
