//레시피 등록 화면
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
class  RecipeRegistrationUI
{
	private JFrame frame;				//프레임
	//음식정보
	private JTextField foodName;		//음식이름
	private JTextField foodCalorie;		//음식 칼로리
	private JTextField foodPhoto;		//음식사진(경로)	
	private JTextArea foodIntro;		//음식소개
		
	//조리정보
	private JTextField cookingTotalTime;//총 조리시간
	private JTextField porton;			//분량
	private JComboBox<String> levelComboBox;			//난이도
	private JTextField totalIngredient;		//재료개수
	private JTextArea tip;				//조리 팁	

	public RecipeRegistrationUI()
	{
		this("예시)볶음밥",0,"예시)경로선택","예시)야채와 밥을 볶아먹은 요리",0,0,new String[]{"EASY","NORMAL","HARD"},0,"예시)간단한 재료만으로 요리가능!");
	}
	public RecipeRegistrationUI(String foodName,int foodCalorie, String foodPhoto,String foodIntro,
		int cookingTotalTime,int porton,String[] level,int totalIngredient,String tip)
	{
		frame = new JFrame("레시피등록");
		this.foodName = new JTextField(foodName);
		this.foodName.setPreferredSize(new Dimension(400,25));
		this.foodCalorie = new JTextField(Integer.toString(foodCalorie));
		this.foodCalorie.setPreferredSize(new Dimension(350,25));
		this.foodPhoto = new JTextField(foodPhoto);
		this.foodPhoto.setPreferredSize(new Dimension(300,25));
		this.foodIntro = new JTextArea(foodIntro);
		this.foodIntro.setPreferredSize(new Dimension(400,30));
		this.cookingTotalTime = new JTextField(Integer.toString(cookingTotalTime));
		this.cookingTotalTime.setPreferredSize(new Dimension(350,25));
		this.porton = new JTextField(Integer.toString(porton));
		this.porton.setPreferredSize(new Dimension(350,25));
		this.totalIngredient = new JTextField(Integer.toString(totalIngredient));
		this.totalIngredient.setPreferredSize(new Dimension(350,25));
		this.tip = new JTextArea(tip);
		this.tip.setPreferredSize(new Dimension(400,25));
		levelComboBox = new JComboBox<String>();
		this.levelComboBox.setModel(new DefaultComboBoxModel<String>(level));	//콤보박스 내용
	}
	//구성 생성
	public Container createContentPane()
	{
		//Container준비
		Container contentPane = frame.getContentPane();							//프레임의 contentPane가져옴
		JPanel BasicPanel = new JPanel(new GridLayout(2,1));					//바탕패널
		//음식 정보
		JPanel foodInfoPanel = new JPanel(new GridLayout(4,1)); //바탕패널에 넣을 주문자 정보 패널
		foodInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.red),"음식 정보"));
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("음  식    이    름   :"));
		panel1.add(foodName);
		panel1.add(new JLabel(""));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("음  식    칼로리   :"));
		panel2.add(foodCalorie);
		panel2.add(new JLabel(""));
		panel2.add(new JLabel("kcal"));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("음식 사진(경로) :"));
		panel3.add(foodPhoto);
		JButton photoButton = new JButton("사진가져오기");
		ActionListener listener = new PhotoButtonListener(foodPhoto);
		photoButton.addActionListener(listener);
		panel3.add(photoButton);
		panel3.add(new JLabel(""));
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(new JLabel("음  식    소    개   :"));
		panel3.add(new JLabel(""));
		panel3.add(new JLabel(""));
		panel3.add(new JLabel(""));
		JScrollPane foodInfoScroll = new JScrollPane(foodIntro);
		foodInfoScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel4.add(foodInfoScroll);
		panel4.add(new JLabel(""));
		foodInfoPanel.add(panel1);
		foodInfoPanel.add(panel2);
		foodInfoPanel.add(panel3);
		foodInfoPanel.add(panel4);
		//조리법 정보
		JPanel recipeInfoPanel = new JPanel(new GridLayout(5,1)); //바탕패널에 넣을 주문자 정보 패널
		recipeInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.red),"조리 정보"));
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(new JLabel("조   리    시    간  :"));
		panel5.add(cookingTotalTime);
		panel5.add(new JLabel(""));
		panel5.add(new JLabel("sec"));
		JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel6.add(new JLabel("분                  량   :"));
		panel6.add(porton);
		panel6.add(new JLabel(""));
		panel6.add(new JLabel("인분"));
		JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel7.add(new JLabel("난       이       도   :"));
		panel7.add(levelComboBox);
		panel7.add(new JLabel(""));
		JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel8.add(new JLabel("총   재 료 개 수   :"));
		panel8.add(totalIngredient);
		panel8.add(new JLabel(""));
		panel8.add(new JLabel("개"));
		JPanel panel9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel9.add(new JLabel("조       리       팁   :"));
		panel9.add(tip);
		panel9.add(new JLabel(""));
		recipeInfoPanel.add(panel5);
		recipeInfoPanel.add(panel6);
		recipeInfoPanel.add(panel7);
		recipeInfoPanel.add(panel8);
		recipeInfoPanel.add(panel9);
		//버튼 
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //바탕패널에 넣을 주문자 정보 패널
		buttonPanel.setBorder(new LineBorder(Color.red));
		JButton stepInputButton = new JButton("조리과정등록하기");
		ActionListener listener1 = new stepInputListener();
		stepInputButton.addActionListener(listener1);
		JButton ingredientInputButton = new JButton("재료등록하기");
		ActionListener listener2 = new ingredientButtonListener(frame,foodName,totalIngredient);
		ingredientInputButton.addActionListener(listener2);
		JButton recipeInputButton = new JButton("레시피등록하기");
		ActionListener listener3 = new recipeInputListener(frame,foodName,foodCalorie,foodPhoto,foodIntro,cookingTotalTime,
			porton,levelComboBox,totalIngredient,tip);
		recipeInputButton.addActionListener(listener3);
		JButton cancelButton = new JButton("돌아가기");
		cancelButton.addActionListener(new CancelActionListener(frame));
		buttonPanel.add(stepInputButton);
		buttonPanel.add(ingredientInputButton);
		buttonPanel.add(recipeInputButton);
		buttonPanel.add(cancelButton);
		
		
		BasicPanel.add(foodInfoPanel);
		BasicPanel.add(recipeInfoPanel);
		
		contentPane.add(BasicPanel);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
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
	public JFrame getFrame()
	{
		return this.frame;
	}
	public JTextField getFoodName()
	{
		return this.foodName;
	}
	public JTextField getFoodCalorie()
	{
		return this.foodCalorie;
	}
	public JTextField getFoodPhoto()
	{
		return this.foodPhoto;
	}
	public JTextArea getFoodIntro()
	{
		return this.foodIntro;
	}		
	public JTextField getCookingTotalTime()
	{
		return this.cookingTotalTime;
	}
	public JTextField getPorton()
	{
		return this.porton;
	}
	public JComboBox<String> getLevelComboBox()
	{
		return this.levelComboBox;
	}
	public JTextField getTotalIngredient()
	{
		return this.totalIngredient;
	}
	public JTextArea getTip()
	{
		return this.tip;
	}
	public void setFrame(JFrame frame)
	{
		this.frame =frame;
	}
	public void setFoodName(JTextField foodName)
	{
		this.foodName = foodName;
	}
	public void setFoodCalorie(JTextField foodCalorie)
	{
		this.foodCalorie = foodCalorie;
	}
	public void setFoodPhoto(JTextField foodPhoto)
	{
		this.foodPhoto =foodPhoto;
	}
	public void setFoodIntro(JTextArea foodIntro)
	{
		this.foodIntro =foodIntro;
	}		
	public void setCookingTotalTime(JTextField cookingTotalTime)
	{
		this.cookingTotalTime =cookingTotalTime;
	}
	public void setPorton(JTextField porton)
	{
		this.porton = porton;
	}
	public void setLevelComboBox(JComboBox<String> levelComboBox)
	{
		this.levelComboBox = levelComboBox;
	}
	public void setTotalIngredient(JTextField totalIngredient)
	{
		this.totalIngredient =totalIngredient;
	}
	public void setTip(JTextArea tip)
	{
		this.tip =tip;
	}
}
