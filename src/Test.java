import java.util.*;
class Test 
{
	public static void main(String[] args) 
	{

	//	MemberFileIO memberFile = new MemberFileIO();
	//	memberFile.readMember();
		
		MemberDBManager memberDBManager = new MemberDBManager();
		
		memberDBManager.loadMemberInfoList();
		
		memberDBManager.getMemberDAO().disconnect();
		
		//FoodFileIO file = new FoodFileIO();
		//file.readFoodInfo();
	//	file.load();

	//	StoreFileIO storeFile = new StoreFileIO();
	//	storeFile.readStoreInfo();
	//	storeFile.readStoreItemInfoList();
	
		StoreItemDBManager storeItemDBManager = new StoreItemDBManager();
		
		storeItemDBManager.readStoreInfo();
		
		storeItemDBManager.readStoreItemInfoList();
		
		new FoodRecipeDBManager();
	
		//ª—∑¡¡÷±‚
		MainFrameUI UI = new MainFrameUI();
		UI.showUI();
	}
}