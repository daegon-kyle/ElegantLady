/*
	작성자 : 박홍근
	Class : CategoryActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CategoryActionListener implements ActionListener
{
	private JButton button;

	public CategoryActionListener()
	{
		this(new JButton());
	}
	public CategoryActionListener(JButton button)
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
		CategoryFrameUI ui2 = new CategoryFrameUI();
		ui2.showUI();
	}
}