/*
	
	Class : CategorySearchActionListener
*/

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class CategorySearchActionListener implements ActionListener 
{
	private JFrame frame;
	private JTextField text;
	private JScrollPane scrollPane;
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	static boolean what=true;
	public CategorySearchActionListener()
	{
		this(new JFrame(),new JComboBox<String>(),new JComboBox<String>(),  new JScrollPane());
	}
	public CategorySearchActionListener(JFrame frame, JComboBox<String> combo1,JComboBox<String> combo2, JScrollPane scrollPane)
	{
		this.frame=frame;
		this.combo1 = combo1;
		this.combo2 = combo2;
		this.scrollPane=scrollPane;
	}
	//음식목록에서 원하는 음식을 찾아오는 메소드 필요
	//일단 actionPerformed에 넣어두었음
	public void actionPerformed(ActionEvent e)    
	{
		showResult();
	}
	public void showResult() //조건에 맞는 결과값 받아와서 출력해주기
	{

		//멤버변수 text로 사용자의 검색값 입력
		//text 이용하여 음식목록에서 조건에 맞는 음식과 개수 가져오기
		int num=10;	//조건에 맞는 음식 개수
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(num, 1));	//JScroll에 들어갈 가장 큰 패널
		JButton[] foodBu=new JButton[num];		//음식개수에 맞는 버튼 배열 생성
		frame.getContentPane().remove(panel2);
		frame.repaint();
		JLabel[] foodLa=new JLabel[8];	 //		레이블8, 음식명, 재료, 조리시간, 건강정보
		//=======================================
		if(what){
		for (int cnt=0; cnt<2; cnt++)	//나중엔 Collection 받아와서 향상된for문
		{
			JPanel panel3=new JPanel(new GridLayout(1,2));					//사진과 각종 설명 넣을 패널
			JPanel panel4=new JPanel();													//사진 넣을 패널
			JPanel panel5=new JPanel(new GridLayout(4, 2));					//각종 설명 넣을 패널
			//음식코드값을 미리 받아서 String으로 변환 후 button 생성시 추가
			foodBu[cnt]=new JButton(new Integer(cnt).toString(),new ImageIcon("1.jpg"));		//음식코드값과 경로값
			foodBu[cnt].setPreferredSize(new Dimension(200, 200));
			foodLa[0]=new JLabel("요리명 : ", SwingConstants.CENTER);
			foodLa[1]=new JLabel("짜장면", SwingConstants.CENTER);		//나중에는 값 받아오기;
			foodLa[2]=new JLabel("재료 : ", SwingConstants.CENTER);;
			foodLa[3]=new JLabel("당근", SwingConstants.CENTER);			//나중에는 값 받아오기;
			foodLa[4]=new JLabel("조리시간: ", SwingConstants.CENTER);;
			foodLa[5]=new JLabel("30분", SwingConstants.CENTER);		 //나중에는 값 받아오기
			foodLa[6]=new JLabel("건강정보: ", SwingConstants.CENTER);
			foodLa[7]=new JLabel("비만", SwingConstants.CENTER);		   //나중에는 값 받아오기;

			//각종 패널 넣기
			panel4.add(foodBu[cnt]);
			panel5.add(foodLa[0]);
			panel5.add(foodLa[1]);
			panel5.add(foodLa[2]);
			panel5.add(foodLa[3]);
			panel5.add(foodLa[4]);
			panel5.add(foodLa[5]);
			panel5.add(foodLa[6]);
			panel5.add(foodLa[7]);
			panel3.add(panel4);
			panel3.add(panel5);
			panel2.add(panel3);
			foodBu[cnt].addActionListener(new PhotoActionListener(new Integer(cnt).toString())); //코드값 넘기기
		}
		scrollPane.setViewportView(panel2);
		//=======================================
		what=false;
		}
		else{
		//=======================================지워질 것들, 그냥 변화된 그림이 출력될 수 있다는 걸 보여준다.
		//layout 넣기 ...........................6=>9, 7=>10, 8=>11
		JPanel tempPanel=new JPanel();
		tempPanel.add(new JLabel("  "));
		scrollPane.setViewportView(tempPanel);
		JPanel panel9=new JPanel(new GridLayout(1,2));
		JButton  imageIcon3=new JButton(new ImageIcon("2.jpg"));
		imageIcon3.setPreferredSize(new Dimension(200, 200));
		JPanel panel10=new JPanel();
		JPanel panel11=new JPanel(new GridLayout(4, 2));
		panel10.add(imageIcon3);
		JLabel labelS17=new JLabel("요리명 : ", SwingConstants.CENTER);
		JLabel labelS18=new JLabel("탕수육", SwingConstants.CENTER);  //나중에는 값 받아오기
		JLabel labelS19=new JLabel("재료 : ", SwingConstants.CENTER);
		JLabel labelS20=new JLabel("당근", SwingConstants.CENTER);  //나중에는 값 받아오기
		JLabel labelS21=new JLabel("조리시간: ", SwingConstants.CENTER);
		JLabel labelS22=new JLabel("30분", SwingConstants.CENTER);  //나중에는 값 받아오기
		JLabel labelS23=new JLabel("건강정보: ", SwingConstants.CENTER);
		JLabel labelS24=new JLabel("비만", SwingConstants.CENTER);  //나중에는 값 받아오기
		panel11.add(labelS17);
		panel11.add(labelS18);
		panel11.add(labelS19);
		panel11.add(labelS20);
		panel11.add(labelS21);
		panel11.add(labelS22);
		panel11.add(labelS23);
		panel11.add(labelS24);
		panel9.add(panel10);
		panel9.add(panel11);
		panel2.add(panel9);
		scrollPane.setViewportView(panel2);
		}
	}
}
