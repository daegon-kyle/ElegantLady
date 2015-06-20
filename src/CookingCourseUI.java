//양진영
//조리과정 UI
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
public class CookingCourseUI
{
	private JLabel hour;
	private JLabel min;
	private JLabel sec;
	private JLabel ms;
	private String path;
	private String description;
	private int step;
	private String foodCode;
	public CookingCourseUI()
	{
		this("00","00","00","00","","",0,"");
	}
	public CookingCourseUI(String hour,String min, String sec,String ms,String path,String description,int step,String foodCode)
	{
		this.hour=new JLabel(hour);
		this.min=new JLabel(min);
		this.sec=new JLabel(sec);
		this.ms=new JLabel(ms);
		this.path=path;
		this.description=description;
		this.step=step;
		this.foodCode=foodCode;
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
	public String getPath()
	{
		return path;
	}
	public String getDescription()
	{
		return description;
	}
	public int getStep()
	{
		return step;
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
	public void setPath(String path)
	{
		this.path=path;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public void setStep(int step)
	{
		this.step=step;
	}
	public void showUI()
	{
		//프레임
		JFrame frame=new JFrame("요조숙녀");
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		Container contentPane= frame.getContentPane();

		JPanel np=new JPanel();
		JPanel cp=new JPanel();
		JPanel sp=new JPanel();

		//상단(스탑워치+로그인)
		np.setBorder(new EmptyBorder(20,0,0,0));
		this.hour.setFont(new Font("Serif", Font.BOLD, 50));
		this.min.setFont(new Font("Serif", Font.BOLD, 50));
		this.sec.setFont(new Font("Serif", Font.BOLD, 50));
		this.ms.setFont(new Font("Serif", Font.BOLD, 50));
		JLabel colon1 = new JLabel(":");
		JLabel colon2 = new JLabel(":");
		JLabel dot = new JLabel(".");
		colon1.setFont(new Font("Serif", Font.BOLD, 50));
		colon2.setFont(new Font("Serif", Font.BOLD, 50));
		dot.setFont(new Font("Serif", Font.BOLD, 50));
		np.add(hour);
		np.add(colon1);
		np.add(min);
		np.add(colon2);
		np.add(sec);
		np.add(dot);
		np.add(ms);
		//중단(사진+설명)
		JPanel cp1=new JPanel();
		JPanel cp2=new JPanel();
		JLabel photo=new JLabel(new ImageIcon(path));
		cp1.add(photo);
		JLabel des=new JLabel(description);
		cp2.add(des);
		cp.add(cp1);
		cp2.setBorder(new EmptyBorder(10,30,30,10));
		cp.add(cp2);
		cp.setBorder(new EmptyBorder(10,10,10,50));

		//하단부
		JButton back=new JButton("이전");
		JButton stop=new JButton("일시정지");
		JButton start=new JButton("시작");
		JButton next=new JButton("다음");
		sp.setLayout(new GridLayout(1,6));
		sp.add(back);
		sp.add(new JLabel(""));
		sp.add(stop);
		sp.add(start);
		sp.add(new JLabel(""));
		sp.add(next);
		sp.setBorder(new EmptyBorder(0,10,10,10));
		ActionListener lst1=new StopWatchActionListener(hour,min,sec,ms);
		start.addActionListener(lst1);
		stop.addActionListener(lst1);
		ActionListener lst3=new NextActionListener(frame,foodCode,step);
		next.addActionListener(lst3);
		ActionListener lst4=new PrevActionListener(frame,foodCode,step);
		back.addActionListener(lst4);

		contentPane.add(np,BorderLayout.NORTH);
		contentPane.add(cp,BorderLayout.CENTER);
		contentPane.add(sp,BorderLayout.SOUTH);

		//보여주기
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
