/*
�̸� : ����
class : TodayActionListener
�󼼼��� : ���ù�����? ���� �˻� ��ư Ŭ���Ͽ��� ��� �˻��� �ҷ��ͼ� ������ش�.
*/
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;

public class TodayActionListener implements ActionListener 
{
	private JFrame frame;						//��Ʋ				
	private JTextField text;					//�˻�â�� ����ڰ� �Է��� ��
	private JScrollPane scrollPane;			//�������� ������ scrollPane
	public TodayActionListener()
	{
		this(new JFrame(), new JTextField(30),  new JScrollPane());
	}
	public TodayActionListener(JFrame frame, JTextField text, JScrollPane scrollPane)
	{
		this.frame=frame;
		this.text=text;
		this.scrollPane=scrollPane;
	}
	//���ĸ�Ͽ��� ���ϴ� ������ ã�ƿ��� �޼ҵ� �ʿ�
	//�ϴ� actionPerformed�� �־�ξ���
	public void actionPerformed(ActionEvent e)    
	{
		showResult();
	}
	public void showResult() //���ǿ� �´� ����� �޾ƿͼ� ������ֱ�
	{
		TodayController control=new TodayController(text.getText());
		LinkedList<FoodRecipeInfo> list=(LinkedList<FoodRecipeInfo>)(control.verifyFoodName());
		//������� text�� ������� �˻��� �Է�
		//text �̿��Ͽ� ���ĸ�Ͽ��� ���ǿ� �´� ���İ� ���� ��������
		int num=list.size();	//���ǿ� �´� ���� ����
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(num, 1));	//JScroll�� �� ���� ū �г�
		JButton[] foodBu=new JButton[num];		//���İ����� �´� ��ư �迭 ����
		frame.getContentPane().remove(panel2);
		frame.repaint();
		JLabel[] foodLa=new JLabel[8];	 //		���̺�8, ���ĸ�, ���, �����ð�, �ǰ�����
		//=======================================
		int cnt=0;
		for (FoodRecipeInfo tmp:list)	//���߿� Collection �޾ƿͼ� ����for��
		{
			JPanel panel3=new JPanel(new GridLayout(1,2));					//������ ���� ���� ���� �г�
			JPanel panel4=new JPanel();													//���� ���� �г�
			JPanel panel5=new JPanel(new GridLayout(4, 2));					//���� ���� ���� �г�
			//�����ڵ尪�� �̸� �޾Ƽ� String���� ��ȯ �� button ������ �߰�
			String str="";
			for (RecipeIngreInfo recipeIngreInfo : (((LinkedList<RecipeIngreInfo>) (tmp.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) )))
			{
				str+=recipeIngreInfo.getIngredientName()+",";
			}

			foodBu[cnt]=new JButton(tmp.getFoodInfo().getFoodCode(),new ImageIcon(tmp.getFoodInfo().getFoodPhoto()));		//�����ڵ尪�� ��ΰ�
			foodBu[cnt].setPreferredSize(new Dimension(200, 200));
			foodLa[0]=new JLabel("�丮�� : ", SwingConstants.CENTER);
			foodLa[1]=new JLabel(tmp.getFoodInfo().getFoodName(), SwingConstants.CENTER);		//���߿��� �� �޾ƿ���;
			foodLa[2]=new JLabel("��� : ", SwingConstants.CENTER);;
			//foodLa[3]=new JLabel( ( (LinkedList<RecipeIngreInfo>) (tmp.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList()) ).get(0).getIngredientName(), SwingConstants.CENTER);			//���߿��� �� �޾ƿ���;
			foodLa[3]=new JLabel( str, SwingConstants.CENTER);
			System.out.println(str);
			foodLa[4]=new JLabel("�����ð�: ", SwingConstants.CENTER);;
			foodLa[5]=new JLabel(new Integer(tmp.getRecipeInfo().getCookingTotalTime()).toString(), SwingConstants.CENTER);		 //���߿��� �� �޾ƿ���
			foodLa[6]=new JLabel("���ļҰ�: ", SwingConstants.CENTER);
			foodLa[7]=new JLabel(tmp.getFoodInfo().getFoodIntro(), SwingConstants.CENTER);		   //���߿��� �� �޾ƿ���;

			//���� �г� �ֱ�
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
			foodBu[cnt].addActionListener(new PhotoActionListener(tmp.getFoodInfo().getFoodCode().toString())); //�ڵ尪 �ѱ��
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
