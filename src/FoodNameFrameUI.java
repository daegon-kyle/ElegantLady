// 작성자 : 박홍근
// 클래스명 : FoodNameFrameUI
// 기능 : 음식명화면

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FoodNameFrameUI
{
	private JLabel label; // 요리명
	private JTextField text; // 요리명검색 textfield
	private JButton button;  // 검색버튼
	private JTable table;

	//--------------------------- constructor --------------------------
	public FoodNameFrameUI()
	{
		String colNames[] = {""};
		String[][] data = {{""},
						{""}};

		this.label = new JLabel("요리명");
		this.text = new JTextField();
		this.button = new JButton("검색");
		this.table = new JTable(data,colNames);
	}
	public FoodNameFrameUI(String foodName,String buttonName,String[] colName,String[][] data)
	{
		this.label = new JLabel(foodName);
		this.text = new JTextField();
		this.button = new JButton(buttonName);
		this.table = new JTable(data,colName);
		
	}
	//--------------------------- set/get Method ------------------------

	
	public JLabel getLabel()
	{
		return this.label;
	}
	public void setLabel(JLabel label)
	{
		this.label= label;
	}
	public JTextField getTextField()
	{
		return text;
	}
	public void setTextField(JTextField text)
	{
		this.text = text;
	}
	public JButton getButton()
	{
		return this.button;
	}
	public void setButton(JButton button)
	{
		this.button = button;
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
		
		cons.ipady = 10;
		cons.ipadx = 10;
		cons.gridx = 1;
		cons.gridy = 3;
		
		gridBag.setConstraints(label,cons);
		panel2.add(label);

		cons.ipady = 10;
		cons.ipadx = 200;
		cons.gridx = 2;
		cons.gridy = 3;
		gridBag.setConstraints(text,cons);
		panel2.add(text);

		cons.ipady = 5;
		cons.ipadx = 10;
		cons.gridx = 3;
		cons.gridy = 3;
		gridBag.setConstraints(button,cons);
		panel2.add(button);
		
		panel1.add(panel2);
		
		contentPane.add(panel1,BorderLayout.NORTH);
		JPanel center = new JPanel(new BorderLayout());
		center.setBorder(new TitledBorder(new EtchedBorder(),"음식목록"));

		JPanel panel5 = new JPanel();//리스너로 넘겨서 데이터 가져오는 panel
		JScrollPane scroll = new JScrollPane(panel5);

		
		center.add(scroll,BorderLayout.CENTER);

		contentPane.add(center,BorderLayout.CENTER);
		contentPane.add(new JLabel("               "),BorderLayout.EAST);
		contentPane.add(new JLabel("               "),BorderLayout.WEST);
		
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,3,5,5));

		contentPane.add(panel3,BorderLayout.SOUTH);



		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//------------------------------------------- listener !!!!!!!!!! -----------------
		button.addActionListener(new SearchActionListener(frame, text, scroll));//음식검색
		
		frame.pack();
		frame.setVisible(true);
	}
}