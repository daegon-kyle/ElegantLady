//재료 등록 ui
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class IngredientInputUI 
{
	private JFrame frame;				//프레임
	private JLabel recipeName;			//요리명
	private JTextField ingredientTotalNum;	//재료의 총 개수
	private JTextField[] ingredientName;	//재료 배열	
	private JTextField[] ingredientNum;		//재료수 배열
	public IngredientInputUI()
	{
		this("요리명",4);
	}
	public IngredientInputUI(String recipeName,int ingredientTotalNum)
	{
		this.frame = new JFrame("재료 등록");
		this.recipeName = new JLabel(recipeName);
		this.ingredientTotalNum = new JTextField(Integer.toString(ingredientTotalNum));
		this.ingredientName = new JTextField[ingredientTotalNum];
		this.ingredientNum = new JTextField[ingredientTotalNum];
		for(int cnt = 0; cnt < ingredientTotalNum; cnt++)
		{
			this.ingredientName[cnt] = new JTextField("");
			this.ingredientName[cnt].setPreferredSize(new Dimension(100,25));
			this.ingredientNum[cnt] = new JTextField("1");
			this.ingredientNum[cnt].setPreferredSize(new Dimension(100,25));
		}
	}
	//구성 생성
	public Container createContentPane()
	{
		//Container준비
		Container contentPane = frame.getContentPane();		//프레임의 contentPane가져옴
		JPanel panel1 = new JPanel(new GridLayout(ingredientName.length,1));//스크롤에 넣을 패널
		JPanel[] panel2 = new JPanel[ingredientName.length];		//스크롤에 넣을 패널의 개수
		JPanel panel3 = new JPanel();						//버튼 넣는 패널		

		//panel2구성
		for(int cnt = 0; cnt < ingredientName.length ; cnt++)
		{
			panel2[cnt] = new JPanel(new FlowLayout());			
			panel2[cnt].add(new JLabel("	"));
			panel2[cnt].add(new JLabel("재료"+(cnt+1)));
			panel2[cnt].add(new JLabel(" "));
			panel2[cnt].add(new JLabel("재료명 : "));
			panel2[cnt].add(ingredientName[cnt]);
			panel2[cnt].add(new JLabel("				"));
			panel2[cnt].add(new JLabel("수  량 : "));	
			panel2[cnt].add(ingredientNum[cnt]);
			panel2[cnt].add(new JLabel("개(g)"));
			panel2[cnt].add(new JLabel("				"));
		}
		//panel1에 panel2넣음
		for(int cnt= 0; cnt < ingredientName.length; cnt++)
		{
			panel1.add(panel2[cnt]);
		}
		//버튼생성
		JButton ingredientRegisterButton = new JButton("재료 등록하기");
		ingredientRegisterButton.addActionListener(
			new IngredientRegisterListener(frame,recipeName,ingredientTotalNum,ingredientName,ingredientNum));
		JButton cancelButton = new JButton("돌아가기");
		cancelButton.addActionListener(new CancelActionListener(frame));
		//panel3 구성 (버튼 합)
		panel3.add(ingredientRegisterButton,BorderLayout.NORTH);
		panel3.add(cancelButton,BorderLayout.NORTH);
		panel3.setBorder(new TitledBorder(""));
		//합치기		
		JScrollPane basicScrollPane =  new JScrollPane(panel1);
		basicScrollPane.setBorder(new TitledBorder(new LineBorder(Color.red),recipeName.getText()));
		contentPane.add(basicScrollPane,BorderLayout.CENTER);
		contentPane.add(panel3,BorderLayout.SOUTH);
		return contentPane;
	}
	//ui생성
	public void showUI()
	{
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		frame.pack();
		frame.setVisible(true);
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	public void setRecipeName(JLabel recipeName)
	{
		this.recipeName =recipeName;
	}
	public void setIngredientTotalNum(JTextField ingredientTotalNum)
	{
		this.ingredientTotalNum =ingredientTotalNum;
	}
	public void setIngredientName(JTextField[] ingredientName)
	{
		this.ingredientName = ingredientName;
	}
	public void setIngredientNum(JTextField[] ingredientNum)
	{
		this.ingredientNum =ingredientNum;
	}
	public JFrame getFrame()
	{
		return this.frame;		
	}
	public JLabel getRecipeName()
	{
		return this.recipeName;		
	}
	public JTextField getIngredientTotalNum()
	{
		return this.ingredientTotalNum;
	}
	public JTextField[] getIngredientName()
	{
		return this.ingredientName;
	}
	public JTextField[] getIngredientNum()
	{
		return this.ingredientNum;
	}
}
