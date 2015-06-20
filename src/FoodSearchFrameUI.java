// 작성자 : 박홍근
// 클래스명 : FoodSearchFrameUI
// 기능 : 음식검색

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FoodSearchFrameUI
{
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	//--------------------------- constructor --------------------------
	public FoodSearchFrameUI()
	{
		this(new JFrame("요조숙녀~"),new JButton("음식명"),new JButton("카테고리별검색"),new JButton("음식추천"),new JButton("로그인"));
	}
	public FoodSearchFrameUI(JFrame frame,JButton button1,JButton button2,JButton button3,JButton button4)
	{
		this.frame = frame;
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
	}
	//--------------------------- set/get Method ------------------------

	public JFrame getFrame()
	{
		return this.frame;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public JButton getButton1()
	{
		return this.button1;
	}
	public void setButton1(JButton button1)
	{
		this.button1 = button1;
	}
	public JButton getButton2()
	{
		return this.button2;
	}
	public void setButton2(JButton button2)
	{
		this.button2 = button2;
	}
	public JButton getButton3()
	{
		return this.button3;
	}
	public void setButton3(JButton button3)
	{
		this.button3 = button3;
	}
	public JButton getButton4()
	{
		return this.button4;
	}
	public void setButton4(JButton button4)
	{
		this.button4 = button4;
	}

	//----------------------- instance method ----------------------------

	public void showUI()
	{
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("그림3.gif"));

		button1.setSize(130,60);
		button1.setLocation(100,50);

		button2.setSize(130,60);
		button2.setLocation(250,50);

		button3.setSize(130,60);
		button3.setLocation(400,50);

		button4.setSize(75,20);
		button4.setLocation(530,15);
		
		label.setSize(500,300);
		label.setLocation(60,70);

		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(label);
		
	

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//------------------------------------------- listener !!!!!!!!!! -----------------
		button1.addActionListener(new FoodNameActionListener(button1));
		button2.addActionListener(new CategoryActionListener(button2));
		button3.addActionListener(new RecommendActionListener(button3));
		button4.addActionListener(new LoginButtonActionListener(button4));
		
		
		frame.pack();
		frame.setVisible(true);
	}
}