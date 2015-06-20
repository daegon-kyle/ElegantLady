//������
//���Ŀ� ���� ������ ���� ���� �� ����ֹ�/�丮���� ���ð���
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class FoodInfoUI
{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private String path;
	private String foodCode;
	public FoodInfoUI()
	{
		this("","",0,"","","");
	}
	public FoodInfoUI(String name,String ingredient,int time,String info,String path,String foodCode)
	{
		this.label1=new JLabel(name);
		this.label2=new JLabel(ingredient);
		this.label3=new JLabel(calcTime(time));
		this.label4=new JLabel(info);
		this.path=path;
		this.foodCode=foodCode;
	}
	public JLabel getLabel1()
	{
		return this.label1;
	}
	public JLabel getLabel2()
	{
		return this.label2;
	}
	public JLabel getLabel3()
	{
		return this.label3;
	}
	public JLabel getLabel4()
	{
		return this.label4;
	}
	public String getPath()
	{
		return path;
	}
	public String getFoodCode()
	{
		return foodCode;
	}
	public void setLabel1(JLabel label1)
	{
		this.label1=label1;
	}
	public void setLabel2(JLabel label2)
	{
		this.label2=label2;
	}
	public void setLabel3(JLabel label3)
	{
		this.label3=label3;
	}
	public void setLabel4(JLabel label4)
	{
		this.label4=label4;
	}
	public void setPath(String path)
	{
		this.path=path;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	public String calcTime(int time)
	{
		return (time/3600)+"�ð�"+(time/60) +"��"+(time%60)+"��";
	}
	public void showUI()
	{
		JFrame frame=new JFrame("��������");
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane= frame.getContentPane();
		//�Է¹޴°�	

		JPanel np=new JPanel(new GridLayout(4,1));
		np.add(new JLabel(" "));
		np.add(new JLabel(" "));
		np.add(new JLabel(" "));
		np.add(new JLabel(" "));
		

		//���
		JPanel cp=new JPanel(new FlowLayout());
		JLabel photo=new JLabel(new ImageIcon(path));

		JPanel cp11=new JPanel(new GridLayout(10,1));
		JPanel cp12=new JPanel(new GridLayout(10,1));
		cp11.add(new JLabel(" "));
		cp11.add(new JLabel(" "));
		cp11.add(new JLabel(" "));
		cp11.add(new JLabel("�� �� �� :"));
		cp11.add(new JLabel("��    �� :"));
		cp11.add(new JLabel("�����ð� :"));
		cp11.add(new JLabel("�ǰ����� :"));
		cp11.add(new JLabel(" "));
		cp11.add(new JLabel(" "));
		cp11.add(new JLabel(" "));
		cp11.setBorder(new EmptyBorder(0,10,0,0));
		cp.add(photo);
		cp.add(cp11);

		cp12.add(new JLabel(" "));
		cp12.add(new JLabel(" "));
		cp12.add(new JLabel(" "));
		cp12.add(label1);
		cp12.add(label2);
		cp12.add(label3);
		cp12.add(label4);
		cp12.add(new JLabel(" "));
		cp12.add(new JLabel(" "));
		cp12.add(new JLabel(" "));
		cp.add(cp12);

		//�Ʒ��ʹ�ư
		JPanel sp=new JPanel();
		JButton ob=new JButton("����ֹ�");
		JButton sb=new JButton("�丮����");
		sp.add(ob);
		sp.add(sb);
		sp.setBorder(new EmptyBorder(0,0,50,0));
		
		contentPane.add(cp,BorderLayout.CENTER);
		contentPane.add(sp,BorderLayout.SOUTH);
		contentPane.add(np,BorderLayout.NORTH);

		//��ư����
		ActionListener lst1=new  OrderActionListener(foodCode);
		ob.addActionListener(lst1);
		ActionListener lst2=new CookingActionListener(frame,foodCode);
		sb.addActionListener(lst2);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}