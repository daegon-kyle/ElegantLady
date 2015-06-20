/*
	작성자 : 박홍근
	Class : SpecialRecommendFoodActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SpecialRecommendFoodActionListener implements ActionListener
{
	private JButton button;

	public SpecialRecommendFoodActionListener()
	{
		this(new JButton());
	}
	public SpecialRecommendFoodActionListener(JButton button)
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
		TodayEatUI ui = new TodayEatUI();
		ui.showUI();
	}
}