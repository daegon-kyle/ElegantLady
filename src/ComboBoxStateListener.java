//박홍근
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxStateListener implements ItemListener
{
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	private String[] stu; // 상황별 목록 배열
	private String[] met; // 방법별 목록 배열
	private String[] ingre; // 재료별 목록 배열

	public ComboBoxStateListener()
	{
		this.combo1 = new JComboBox<String>();
		this.combo2 = new JComboBox<String>();

		this.stu[0] = "상황별1";
		this.stu[1] = "상황별2";
		this.stu[2] = "상황별3";

		this.met[0] = "방법별1";
		this.met[1] = "방법별2";
		this.met[2] = "방법별3";

		this.ingre[0] = "재료별1";
		this.ingre[1] = "재료별2";
		this.ingre[2] = "재료별3";

	}
	public ComboBoxStateListener(JComboBox<String> combo1,JComboBox<String> combo2,String[] stu,String[] met,String[] ingre)
	{
		this.combo1 = combo1;
		this.combo2 = combo2;
		this.stu = stu;
		this.met = met;
		this.ingre = ingre;
	}
	public void itemStateChanged(ItemEvent e)
	{
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		
		
		if(cb.getSelectedItem().equals("상황별"))
		{
			combo2.removeAllItems();
			for(String temp : stu)
				combo2.addItem(temp);
		}
		else if(cb.getSelectedItem().equals("방법별"))
		{
			combo2.removeAllItems();
			for(String temp : met)
				combo2.addItem(temp);
		}
		else if(cb.getSelectedItem().equals("재료별"))
		{
			combo2.removeAllItems();
			for(String temp : ingre)
				combo2.addItem(temp);
		}
	}

}
