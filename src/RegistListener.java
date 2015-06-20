import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class RegistListener implements ActionListener 
{
	private JFrame frame;
	private JTextField photoPath;
	private JTextField time;
	private JTextArea description;	

	public RegistListener()
	{
		this(new JFrame(""),new JTextField(),new JTextField(),new JTextArea());
	}
	public RegistListener(JFrame frame,JTextField photoPath,JTextField time, JTextArea description){
		this.frame = frame;
		this.photoPath = photoPath;
		this.time = time;
		this.description = description;
	}
	public void actionPerformed(ActionEvent e)
	{
		addRegist();
		frame.dispose();
		RecipeCourseUI obj = new RecipeCourseUI();
		obj.showUI();
	}
	public void addRegist()
	{
		CookingCourseRegistController obj = new CookingCourseRegistController(photoPath,time,description);
		obj.tempRegister();
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	public JTextField getPhotoPath()
	{
		return this.photoPath;
	}
	public JTextField getTime()
	{
		return this.time;
	}
	public JTextArea getDescription()
	{
		return this.description;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setPhotoPath(JTextField photoPath)
	{
		this.photoPath= photoPath;
	}
	public void setTime(JTextField time)
	{
		this.time= time;	
	}
	public void getDescription(JTextArea description)
	{
		this.description = description;
	}
	
}

