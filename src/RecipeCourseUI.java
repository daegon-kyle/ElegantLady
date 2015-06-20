/* 
	조리과정등록UI
	작성자 : 김영한
	//수정함
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
class RecipeCourseUI
{
	private JFrame frame;
	private JTextField photoPath;
	public RecipeCourseUI() {
		this(new JFrame("조리과정 등록"),new JTextField("음식경로"));
	} 
	public RecipeCourseUI(JFrame frame)
	{
		this(frame,new JTextField("음식경로"));
	}
	public RecipeCourseUI(JTextField photoPath)
	{
		this(new JFrame("조리과정 등록"),photoPath);
	}	
	public RecipeCourseUI(JFrame frame,JTextField photoPath)
	{
		this.frame = frame;
		this.photoPath = photoPath;
		this.photoPath.setPreferredSize(new Dimension(500,25));
	}
	public JFrame getFrame(){
		return frame;
	}
	public JTextField getPhotoPath()
	{
		return this.photoPath;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setPhotoPath(JTextField photoPath)
	{
		this.photoPath = photoPath;
	}
	public void showUI()
	{
		Container contentPane = frame.getContentPane();
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
/////////////////////////////////////////////////////
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel1.setBorder(new TitledBorder(new LineBorder(Color.red),"조리과정 등록"));

		JPanel panel1_1 = new JPanel();
		panel1_1.setLayout(new GridLayout(6,1));
		panel1_1.add(new JLabel(""));
		JPanel panel1_1_1 = new JPanel();
		panel1_1_1.setLayout(new GridLayout(1,7));
		JPanel panel1_1_2 = new JPanel();
		panel1_1_2.setLayout(new GridLayout(1,7));

///////////////////////////////////////////////////////
		JLabel timeLabel = new JLabel(" 단계시간(초) ");
		JTextField time = new JTextField(10);
		JLabel pathLabel = new JLabel(" 사진경로   ");
		JButton selButton = new JButton("사진선택");
		

//////////////////////////////////////////////////////
		panel1_1_1.add(timeLabel);
		panel1_1_1.add(time);
		panel1_1_1.add(new JLabel(""));
		panel1_1_1.add(new JLabel(""));
		panel1_1_1.add(new JLabel(""));
		panel1_1_1.add(new JLabel(""));
		panel1_1_1.add(new JLabel(""));
		panel1_1.add(panel1_1_1);

		panel1_1_2.add(pathLabel);
		panel1_1_2.add(photoPath);
		panel1_1_2.add(selButton);
		panel1_1_2.add(new JLabel(""));
		panel1_1_2.add(new JLabel(""));
		panel1_1_2.add(new JLabel(""));
		panel1_1_2.add(new JLabel(""));
		
		panel1_1.add(panel1_1_2);
//////////////////////////////////////////////////////

		JPanel panel1_2 = new JPanel();
		panel1_2.setLayout(new BorderLayout());
		JLabel label2 = new JLabel(" 설명  ");
		JTextArea description = new JTextArea(5,2);
		description.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(description);
		panel1_2.add(label2,BorderLayout.WEST);
		panel1_2.add(scrollPane,BorderLayout.CENTER);

		panel1.add(panel1_1);
		panel1.add(panel1_2);
///////////////////////////////////////////////////////

		JPanel panel2 = new JPanel();
		JButton registButton = new JButton("등록");
		JButton endButton = new JButton("완료");
		panel2.add(registButton);
		panel2.add(endButton);
//////////////////////////////////////////////////////

		contentPane.add(panel1,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		ActionListener lst1 = new FileSelListener(photoPath);			//사진 선택
		selButton.addActionListener(lst1);

		ActionListener lst2 = new RegistListener(frame,photoPath,time,description);//등록 
		registButton.addActionListener(lst2);

		ActionListener lst3 = new EndButtonListener(frame);//완료
		endButton.addActionListener(lst3);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

}
