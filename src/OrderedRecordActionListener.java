/*
	작성자 : 박홍근
	Class : OrderedRecordActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OrderedRecordActionListener implements ActionListener
{
	private JButton button;

	public OrderedRecordActionListener()
	{
		this(new JButton());
	}
	public OrderedRecordActionListener(JButton button)
	{
		this.button = button;
	}

	public void setJButton(JButton button)
	{
		this.button = button;
	}
	public JButton getJButton()
	{
		return this.button;
	}

	public void actionPerformed(ActionEvent e)
	{
		LoginCheckController controller = new LoginCheckController();
		if(controller.loginCheck())
		{
			System.out.println("orderedRecdList");
			OrderRecordListUI ui = new OrderRecordListUI();
			ui.showUI();
		}
	}
}