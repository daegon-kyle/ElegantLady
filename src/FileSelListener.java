import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
class FileSelListener implements ActionListener 
{	
	private JTextField photoPath;
	public FileSelListener()
	{
		this(new JTextField("°æ·Î"));
	}
	public FileSelListener(JTextField photoPath)
	{
		this.photoPath = photoPath;
	}
	public void actionPerformed(ActionEvent e)
	{
		getPhotoPath();
	}
	public void getPhotoPath()
	{
		PhotoButtonController obj = new PhotoButtonController(photoPath);
		this.photoPath = obj.importPhotoPath();
		/*
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(chooser);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File file = chooser.getSelectedFile();
			this.photoPath.setText(file.getPath());
		}
		*/
	}
}
