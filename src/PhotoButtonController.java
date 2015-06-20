import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
class PhotoButtonController implements ActionListener 
{	
	private JTextField photoPath;
	public PhotoButtonController()
	{
		this(new JTextField("°æ·Î"));
	}
	public PhotoButtonController(JTextField photoPath)
	{
		this.photoPath = photoPath;
	}
	public void actionPerformed(ActionEvent e)
	{
		importPhotoPath();
	}
	public JTextField importPhotoPath()
	{
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(chooser);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File file = chooser.getSelectedFile();
			this.photoPath.setText(file.getPath());
			return this.photoPath;
		}
		return null;
	}
}
