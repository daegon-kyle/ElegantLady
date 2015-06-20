import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class  OrderIngredientUI
{
	private JFrame frame;						//프레임
	private JLabel recipiName;					//레시피이름
	private JCheckBox[] checkBox;				//체크박스
	private JComboBox<String> comboBox1;		//매장 선택 콤보박스
	private JComboBox<String> comboBox2;		//배송시간 선택 콤보박스
	private JSpinner[] spinner;					//스피너
	//private SpinnerNumberModel[] ingredientNum;	//스피너 개수
	//생성자
	OrderIngredientUI()
	{
		this("레시피이름",new String[]{"방배점","이수점","청담점"},
			new String[]{"12:00~01:00","02:00~06:00","06:00~08:00"},
			new String[]{"재료1","재료2","재료3","재료4","재료5","재료6","재료7","재료8","재료9","재료10","재료11","재료12"});
	}
	//오버로디드 생성자
	OrderIngredientUI(String recipiName,String[] store,String[] storeTime,String[] ingredient)
	{
		this.frame = new JFrame("재료주문");			//프레임 			
		this.recipiName = new JLabel(recipiName);	//레시피 이름 	
		//체크박스
		this.checkBox = new JCheckBox[ingredient.length];//체크박스
		for(int cnt = 0; cnt <ingredient.length; cnt++ )//각각의 체크박스 
		{
			checkBox[cnt] = new JCheckBox(ingredient[cnt],false);
		}
		//콤보박스
		this.comboBox1=new JComboBox<String>();		//판매처 콤보박스
		this.comboBox1.setModel(new DefaultComboBoxModel<String>(store));//콤보박스 내용
		this.comboBox2=new JComboBox<String>();		//배송시간 콤보박스
		this.comboBox2.setModel(new DefaultComboBoxModel<String>(storeTime));
		//스피너 
		SpinnerNumberModel[] ingredientNum = new SpinnerNumberModel[ingredient.length];		//스피너의 개수
		for(int cnt = 0; cnt < ingredient.length;cnt++)										//각각의 스피너의 제한 설정
		{
			ingredientNum[cnt] = new SpinnerNumberModel(1, 1, null, 1);						//초기값, 최소값, 최대값, 단계
		}
		this.spinner = new JSpinner[ingredient.length];
		for(int cnt = 0; cnt < ingredient.length;cnt++)
		{
			spinner[cnt]= new JSpinner();
			spinner[cnt].setModel(ingredientNum[cnt]);
		}
	}
	//구성 생성
	public Container createContentPane()
	{
		//Container준비
		Container contentPane = frame.getContentPane();		//프레임의 contentPane가져옴
		//패널 구성
		JPanel panel1 = new JPanel(new BorderLayout());		//목록과, 매장선택, 배송시간을 넣는 큰 패널
		JPanel panel2 = new JPanel(new GridLayout(checkBox.length,1));//스크롤에 넣을 패널
		JPanel panel3 = new JPanel();						//매장 선택,배송시간을 넣는 패널
		JPanel panel4 = new JPanel();						//주문, 돌아가기
		
		//----------------- listener ------------------------------------------------
		JButton button1 = new JButton("주문하기");
		button1.addActionListener(new OrderListener());
		JButton button2 = new JButton("돌아가기");
		button2.addActionListener(new CancelActionListener(frame));
		

		JPanel[] panel5 = new JPanel[checkBox.length];		//재료명, 수량,을 넣을 패널
		//panel5구성
		for(int cnt = 0; cnt < checkBox.length ; cnt++)
		{
			panel5[cnt] = new JPanel(new GridLayout(1,3));			//flow / grid(1,3)			
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel(""));			
			panel5[cnt].add(checkBox[cnt]);
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel("수량"));			
			panel5[cnt].add(spinner[cnt]);
			panel5[cnt].add(new JLabel(""));
			panel5[cnt].add(new JLabel(""));
		}
		//panel2에 panel5넣음
		for(int cnt= 0; cnt < checkBox.length; cnt++)
		{
			panel2.add(panel5[cnt]);
		}
		//scrollpane에 panel2넣음
		JScrollPane scrollPane = new JScrollPane(panel2);
		//panel3구성
		panel3.add(new JLabel("매장선택"));	//매장선택
		panel3.add(this.comboBox1);
		panel3.add(new JLabel(""));
		panel3.add(new JLabel("배송시간"));
		panel3.add(this.comboBox2);
		//panel1구성 (scrollPane,panel3합)
		panel1.add(scrollPane,BorderLayout.CENTER);
		panel1.add(panel3,BorderLayout.SOUTH);
		panel1.setBorder(new TitledBorder(recipiName.getText()));
		//panel4 구성 (panel1,panel3합)
		panel4.add(button1,BorderLayout.NORTH);
		panel4.add(button2,BorderLayout.NORTH);
		panel4.setBorder(new TitledBorder(""));
		
		contentPane.add(panel1,BorderLayout.CENTER);
		contentPane.add(panel4,BorderLayout.SOUTH);			

		return contentPane;
	}
	//ui생성
	public void showUI()
	{
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300,150);
		frame.setPreferredSize(new Dimension(640,420));
		frame.pack();
		frame.setVisible(true);
	}
}

 
    