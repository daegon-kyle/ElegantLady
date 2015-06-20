// 작성자 : 박홍근
// 클래스명 : CategoryFrameUI
// 기능 : 카테고리별검색UI

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CategoryFrameUI
{
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	private JTable table;

	//--------------------------- constructor --------------------------
	public CategoryFrameUI()
	{
		String[] str1 = {"상황별","재료별","방법별"};
		String[] str2 = {"생일상","돌상","잔칫상"};

		String colNames[] = {"음식명","재료","소개","조리시간"};
		String[][] data = {{"탕수육","돼지고기","중국음식","1시간"},
						{"유산슬","해삼","중국음식","1시간"}};

		this.combo1 = new JComboBox<String>(str1);
		this.combo2 = new JComboBox<String>(str2);
		this.table = new JTable(data,colNames);
	}
	public CategoryFrameUI(String[] str1,String[] str2,String colNames[],String[][] data)
	{
		this.combo1 = new JComboBox<String>(str1);
		this.combo2 = new JComboBox<String>(str2);
		this.table = new JTable(data,colNames);
		
	}
	//--------------------------- set/get Method ------------------------

	public JComboBox<String> getCombo1()
	{
		return combo1;
	}
	public void setCombo1(JComboBox<String> combo1)
	{
		this.combo1 = combo1;
	}
	public JComboBox<String> getCombo2()
	{
		return combo2;
	}
	public void setCombo2(JComboBox<String> combo2)
	{
		this.combo2 = combo2;
	}
	public JTable getTable()
	{
		return this.table;
	}
	public void setTable(JTable table)
	{
		this.table = table;
	}
	
	//----------------------- instance method ----------------------------

	public void showUI()
	{
		JFrame frame = new JFrame("요조숙녀");
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane = frame.getContentPane();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(10,10,10,10));

		cons.fill = GridBagConstraints.BOTH;
		panel2.setLayout(gridBag);
		

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 1;
		cons.gridy = 7;
		
		JLabel label1 = new JLabel("카테고리");
		gridBag.setConstraints(label1,cons);
		panel2.add(label1);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 2;
		cons.gridy = 7;

		gridBag.setConstraints(combo1,cons);
		panel2.add(combo1);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 3;
		cons.gridy = 7;
		
		JLabel label5 = new JLabel("     ");
		gridBag.setConstraints(label5,cons);
		panel2.add(label5);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 4;
		cons.gridy = 7;
		JLabel label2 = new JLabel("유형");
		gridBag.setConstraints(label2,cons);
		panel2.add(label2);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 5;
		cons.gridy = 7;
		gridBag.setConstraints(combo2,cons);
		panel2.add(combo2);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 6;
		cons.gridy = 7;
		
		JLabel label6 = new JLabel("     ");
		gridBag.setConstraints(label6,cons);
		panel2.add(label6);

		cons.ipady = 5;
		cons.ipadx = 5;
		cons.gridx = 7;
		cons.gridy = 7;
		JButton button = new JButton("검색");
		gridBag.setConstraints(button,cons);
		panel2.add(button);
		

		panel1.add(panel2);
		
		contentPane.add(panel1,BorderLayout.NORTH);
		JPanel center = new JPanel(new BorderLayout());
		center.setBorder(new TitledBorder(new EtchedBorder(),"음식목록"));

		JPanel panel5 = new JPanel();// 리스너로 넘김.
		JScrollPane scroll = new JScrollPane(panel5);
		center.add(scroll,BorderLayout.CENTER);

		contentPane.add(center,BorderLayout.CENTER);
		contentPane.add(new JLabel("               "),BorderLayout.EAST);
		contentPane.add(new JLabel("               "),BorderLayout.WEST);
		
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,3,5,5));

		contentPane.add(panel3,BorderLayout.SOUTH);

		
		String[] stu = {"상황별1","상황별2","상황별3"};
		String[] met = {"방법별1","방법별2","방법별3"};
		String[] ingre = {"재료별1","재료별2","재료별3"};

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//------------------------------------------- listener !!!!!!!!!! -----------------
		button.addActionListener(new CategorySearchActionListener(frame,combo1,combo2, scroll));//음식검색
		combo1.addItemListener(new ComboBoxStateListener(combo1,combo2,stu,met,ingre));
		
		frame.pack();
		frame.setVisible(true);
	}
}