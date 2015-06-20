/*
	작성자 : 박홍근
	Class : RecommendActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RecommendActionListener implements ActionListener
{
	private JButton button;

	public RecommendActionListener()
	{
		this(new JButton());
	}
	public RecommendActionListener(JButton button)
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
		//FoodRecommendUI ui = new FoodRecommendUI();
		//ui.showUI();
		String[][] food1= {{"","","",""}};
		FoodRecommendUI ui = new FoodRecommendUI(food1);
		ui.showUI();
	}
}