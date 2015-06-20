//��ȫ��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxStateListener implements ItemListener
{
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	private String[] stu; // ��Ȳ�� ��� �迭
	private String[] met; // ����� ��� �迭
	private String[] ingre; // ��Ằ ��� �迭

	public ComboBoxStateListener()
	{
		this.combo1 = new JComboBox<String>();
		this.combo2 = new JComboBox<String>();

		this.stu[0] = "��Ȳ��1";
		this.stu[1] = "��Ȳ��2";
		this.stu[2] = "��Ȳ��3";

		this.met[0] = "�����1";
		this.met[1] = "�����2";
		this.met[2] = "�����3";

		this.ingre[0] = "��Ằ1";
		this.ingre[1] = "��Ằ2";
		this.ingre[2] = "��Ằ3";

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
		
		
		if(cb.getSelectedItem().equals("��Ȳ��"))
		{
			combo2.removeAllItems();
			for(String temp : stu)
				combo2.addItem(temp);
		}
		else if(cb.getSelectedItem().equals("�����"))
		{
			combo2.removeAllItems();
			for(String temp : met)
				combo2.addItem(temp);
		}
		else if(cb.getSelectedItem().equals("��Ằ"))
		{
			combo2.removeAllItems();
			for(String temp : ingre)
				combo2.addItem(temp);
		}
	}

}
