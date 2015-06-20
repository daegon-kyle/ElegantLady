/*
	작성자 : 박홍근
	Class : FoodNameActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FoodNameActionListener implements ActionListener
{
	private JButton button;

	public FoodNameActionListener()
	{
		this(new JButton());
	}
	public FoodNameActionListener(JButton button)
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
		FoodNameFrameUI ui = new FoodNameFrameUI();
		ui.showUI();
	}
}