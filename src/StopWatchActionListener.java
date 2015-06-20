import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StopWatchActionListener implements ActionListener 
{
	private JLabel hour;
	private JLabel min;
	private JLabel sec;
	private JLabel ms;
	private int time;			//해당과정의 소요시간
	private Counter timer;
	public StopWatchActionListener()
	{
		this(new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""));
	}
	public StopWatchActionListener(JLabel hour,JLabel min,JLabel sec,JLabel ms)
	{
		this.hour=hour;
		this.min=min;
		this.sec=sec;
		this.ms=ms;
		this.timer=new Counter(hour,min,sec,ms,(Integer.parseInt(hour.getText())*3600+
			Integer.parseInt(min.getText())*60+Integer.parseInt(sec.getText()))*100);
	}
	public JLabel getHour()
	{
		return hour;
	}
	public JLabel getMin()
	{
		return min;
	}
	public JLabel getSec()
	{
		return sec;
	}
	public JLabel getMs()
	{
		return ms;
	}
	public Counter getTimer()
	{
		return timer;
	}
	public void setHour(JLabel hour)
	{
		this.hour=hour;
	}
	public void setMin(JLabel min)
	{
		this.min=min;
	}
	public void setSec(JLabel sec)
	{
		this.sec=sec;
	}
	public void setMs(JLabel ms)
	{
		this.ms=ms;
	}
	public void setTimer(Counter timer)
	{
		this.timer=timer;
	}
	public void actionPerformed(ActionEvent e)
	{
		int time=timer.getTime();									//요리1개과정의 시간
		if(((JButton)e.getSource()).getText().equals("시작"))
		{
			timer=new Counter(hour,min,sec,ms,time);
			timer.start();
		}
		else
		{
			timer.interrupt();
			timer=new Counter(hour,min,sec,ms,time);
		}
	}
}
