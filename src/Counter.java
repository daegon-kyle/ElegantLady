//양진영
//스탑워치기능(기능클래스)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.applet.*;
public class Counter extends Thread
{
	private JLabel hour;
	private JLabel min;
	private JLabel sec;
	private JLabel msec;
	private int time;
	public Counter()
	{
		this(new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),0);
	}
	public Counter(JLabel hour,JLabel min,JLabel sec,JLabel msec,int time)	//초
	{
		this.hour=hour;
		this.min=min;
		this.sec=sec;
		this.msec=msec;
		this.time=time;
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
	public JLabel getMsec()
	{
		return msec;
	}
	public int getTime()
	{
		return time;
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
	public void setMsec(JLabel msec)
	{
		this.msec=msec;
	}
	public void run()
	{
		calcTime();
	}
	public void calcTime()
	{
		int ms=0;
		int s=0;
		int m=0;
		int h=0;
		//return (time/3600)+"시간"+(time/60) +"분"+(time%60)+"초";
		while(time>=0)
		{
			/*h=time/3600;
			m=(time-h*3600)/60;
			s=time-h*3600-m*60;
			//msec.setText(ms < 10 ? "0" + ms : "" + ms);
			sec.setText(s < 10 ? "0" + s : "" + s);
			min.setText(m < 10 ? "0" + m : "" + m);
			hour.setText(h < 10 ? "0" + h : "" + h);*/

			h = time / (3600 *100);
			m = (time- h * 3600*100 ) / (60 *100);
			s = (time - h * 3600 *100 - m * 60 *100)/100;
			ms = time - h * 3600*100 - m * 60*100 - s*100 ;
			msec.setText(ms < 10 ? "0" + ms : "" + ms);
			sec.setText(s < 10 ? "0" + s : "" + s);
			min.setText(m < 10 ? "0" + m : "" + m);
			hour.setText(h < 10 ? "0" + h : "" + h);
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				return;
			}
			time--;
		}
		try
		{
			File file=new File("효과음.wav");
			AudioClip audioClip=Applet.newAudioClip(file.toURL());
			audioClip.play();			
		}
		catch (MalformedURLException mue)
		{
		}
	}
}