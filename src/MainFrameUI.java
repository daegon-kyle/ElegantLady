// 작성자 : 박홍근
// 클래스명 : MainFrameUI
// 기능 : 시작화면

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrameUI
{
	private JFrame frame;
	private JButton button1;//음식검색
	private JButton button2;//뭐먹지
	private JButton button3;//레시피등록
	private JButton button4;//주문내역확인
	private JButton button5;//로그인버튼

	//--------------------------- constructor --------------------------
	public MainFrameUI()
	{
		this(new JFrame("요조숙녀~"),new JButton("음식검색"),new JButton("뭐먹지?"),new JButton("레시피등록"),new JButton("주문내역확인"),new JButton("로그인"));
	}
	public MainFrameUI(JFrame frame,JButton button1,JButton button2,JButton button3,JButton button4,JButton button5)
	{
		this.frame = frame;
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
		this.button5 = button5;
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
	public JButton getButton5()
	{
		return this.button5;
	}
	public void setButton5(JButton button5)
	{
		this.button5 = button5;
	}

	//----------------------- instance method ----------------------------

	public void showUI()
	{
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("그림3.gif")); //이미지 업로드
		

		button1.setSize(130,60);
		button1.setLocation(20,50);

		button2.setSize(130,60);
		button2.setLocation(170,50);

		button3.setSize(130,60);
		button3.setLocation(320,50);

		button4.setSize(130,60);
		button4.setLocation(470,50);

		button5.setSize(75,20);
		button5.setLocation(530,15);
		
		label.setSize(500,300);
		label.setLocation(60,70);

		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(button5);
		contentPane.add(label); // 이미지삽입
		
	

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//------------------------------------------- listener !!!!!!!!!! -----------------
		button1.addActionListener(new FoodSearchActionListener(button1));//음식검색
		button2.addActionListener(new SpecialRecommendFoodActionListener(button2));//뭐먹지
		button3.addActionListener(new RegistRecipeActionListener(button3));//레시피등록
		button4.addActionListener(new OrderedRecordActionListener(button4));//주문내역확인
		button5.addActionListener(new LoginButtonActionListener(button5));//로그인버튼
		
		frame.pack();
		frame.setVisible(true);
	}
}