/*
	작성자 : 박홍근
	Class : LoginButtonActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginButtonActionListener implements ActionListener
{
	private JButton button;

	public LoginButtonActionListener()
	{
		this(new JButton());
	}
	public LoginButtonActionListener(JButton button)
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
		LoginUI ui = new LoginUI();
		ui.showUI();
	}
}