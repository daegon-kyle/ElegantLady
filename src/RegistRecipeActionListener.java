/*
	작성자 : 박홍근
	Class : RegistRecipeActionListener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegistRecipeActionListener implements ActionListener
{
	private JButton button;

	public RegistRecipeActionListener()
	{
		this(new JButton());
	}
	public RegistRecipeActionListener(JButton button)
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
			System.out.println("registRecipeList");
			RecipeRegistrationUI ui = new RecipeRegistrationUI();
			ui.showUI();
		}
	}
}