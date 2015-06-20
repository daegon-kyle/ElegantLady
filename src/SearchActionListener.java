/*
이름 : 박홍근
class : SearchActionListener
*/
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;

public class SearchActionListener implements ActionListener 
{
	private JFrame frame;						//형틀				
	private JTextField text;					//검색창에 사용자가 입력한 값
	private JScrollPane scrollPane;			//음식정보 저장할 scrollPane
	public SearchActionListener()
	{
		this(new JFrame(), new JTextField(30),  new JScrollPane());
	}
	public SearchActionListener(JFrame frame, JTextField text, JScrollPane scrollPane)
	{
		this.frame=frame;
		this.text=text;
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
		FoodNameSearchController control=new FoodNameSearchController(text.getText());
		LinkedList<FoodRecipeInfo> list=(LinkedList<FoodRecipeInfo>)(control.compareName());
		//멤버변수 text로 사용자의 검색값 입력
		//text 이용하여 음식목록에서 조건에 맞는 음식과 개수 가져오기
		int num=list.size();	//조건에 맞는 음식 개수
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(num, 1));	//JScroll에 들어갈 가장 큰 패널
		JButton[] foodBu=new JButton[num];		//음식개수에 맞는 버튼 배열 생성
		frame.getContentPane().remove(panel2);
		frame.repaint();
		JLabel[] foodLa=new JLabel[8];	 //		레이블8, 음식명, 재료, 조리시간, 건강정보
		//=======================================
		int cnt=0;
		for (FoodRecipeInfo tmp:list)	//나중엔 Collection 받아와서 향상된for문
		{
			JPanel panel3=new JPanel(new GridLayout(1,2));					//사진과 각종 설명 넣을 패널
			JPanel panel4=new JPanel();													//사진 넣을 패널
			JPanel panel5=new JPanel(new GridLayout(4, 2));					//각종 설명 넣을 패널
			//음식코드값을 미리 받아서 String으로 변환 후 button 생성시 추가
			String str="";
			for (RecipeIngreInfo recipeIngreInfo : (((LinkedList<RecipeIngreInfo>) (tmp.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) )))
			{
				str+=recipeIngreInfo.getIngredientName()+",";
			}

			foodBu[cnt]=new JButton(tmp.getFoodInfo().getFoodCode(),new ImageIcon(tmp.getFoodInfo().getFoodPhoto()));		//음식코드값과 경로값
			foodBu[cnt].setPreferredSize(new Dimension(200, 200));
			foodLa[0]=new JLabel("요리명 : ", SwingConstants.CENTER);
			foodLa[1]=new JLabel(tmp.getFoodInfo().getFoodName(), SwingConstants.CENTER);		//나중에는 값 받아오기;
			foodLa[2]=new JLabel("재료 : ", SwingConstants.CENTER);;
			foodLa[3]=new JLabel( str, SwingConstants.CENTER);
			//foodLa[3]=new JLabel( ( (LinkedList<RecipeIngreInfo>) (tmp.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) ).get(0).getIngredientName(), SwingConstants.CENTER);			//나중에는 값 받아오기;
			foodLa[4]=new JLabel("조리시간: ", SwingConstants.CENTER);;
			foodLa[5]=new JLabel(new Integer(tmp.getRecipeInfo().getCookingTotalTime()).toString(), SwingConstants.CENTER);		 //나중에는 값 받아오기
			foodLa[6]=new JLabel("음식소개: ", SwingConstants.CENTER);
			foodLa[7]=new JLabel(tmp.getFoodInfo().getFoodIntro(), SwingConstants.CENTER);		   //나중에는 값 받아오기;

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
			foodBu[cnt].addActionListener(new PhotoActionListener(tmp.getFoodInfo().getFoodCode().toString())); //코드값 넘기기
			cnt++;
		}
		scrollPane.setViewportView(panel2);
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public JTextField getText()
	{
		return text;
	}
	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}
	public void setFrame(JFrame frame)
	{
		this.frame=frame;
	}
	public void setText(JTextField text)
	{
		this.text=text;
	}
	public void setScrollPane(JScrollPane scrollPane)
	{
		this.scrollPane=scrollPane;
	}
}
