/*
	작성자 : 박홍근
	Class : FoodSearchActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FoodSearchActionListener implements ActionListener
{
	private JButton button;

	public FoodSearchActionListener()
	{
		this(new JButton());
	}
	public FoodSearchActionListener(JButton button)
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
		FoodSearchFrameUI frame = new FoodSearchFrameUI();
		frame.showUI();
	}
}