/*
	�ۼ���  : ��ȫ��
	Class�� : FoodFileIO
*/

import java.io.*;
import java.util.*;

public class FoodFileIO 
{
	private CookingCourseListData cookingCourseListData;
	private RecipeIngreInfoListData recipeIngreInfoListData;//����
	private RecipeInfoList recipeInfoList;
	private FoodInfoList foodInfoList;

	//------------------------------- constructor -----------------------------------------
	public FoodFileIO()
	{
		this(new CookingCourseListData(),new RecipeIngreInfoListData(),new RecipeInfoList(),new FoodInfoList());
	}
	public FoodFileIO(CookingCourseListData cookingCourseListData,RecipeIngreInfoListData recipeIngreInfoListData,RecipeInfoList recipeInfoList,FoodInfoList foodInfoList)
	{
		this.cookingCourseListData = cookingCourseListData;
		this.recipeIngreInfoListData = recipeIngreInfoListData;
		this.recipeInfoList = recipeInfoList;
		this.foodInfoList = foodInfoList;
	}
	
	//--------------------------------- get/set method -------------------------------------

	public CookingCourseListData getCookingCourseListData()
	{
		return cookingCourseListData;
	}
	public RecipeIngreInfoListData getRecipeIngreInfoListData()
	{
		return recipeIngreInfoListData;
	}
	public RecipeInfoList getRecipeInfoList()
	{
		return recipeInfoList;
	}
	public FoodInfoList getFoodInfoList()
	{
		return foodInfoList;
	}

	public void setCookingCourseListData(CookingCourseListData cookingCourseListData)
	{
		this.cookingCourseListData = cookingCourseListData;
	}
	public void setRecipeIngreInfoListData(RecipeIngreInfoListData recipeIngreInfoListData)
	{
		this.recipeIngreInfoListData = recipeIngreInfoListData;
	}
	public void setRecipeInfoList(RecipeInfoList recipeInfoList)
	{
		this.recipeInfoList = recipeInfoList;
	}
	public void setFoodInfoList(FoodInfoList foodInfoList)
	{
		this.foodInfoList = foodInfoList;
	}
	
	public void readFoodInfo()
	{
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		BufferedReader reader3 = null;
		BufferedReader reader4 = null;

		try
		{
			reader1 = new BufferedReader(new FileReader("FoodInfoData.txt"));
			
			
			while(true)
			{
				String foodCode = reader1.readLine();
				FoodInfo foodInfo = new FoodInfo();
				if(foodCode == null){break;}
				foodInfo.setFoodCode(foodCode);	//�����ڵ� �б�
				foodInfo.setFoodName(reader1.readLine());	//�����̸� �б�
				foodInfo.setFoodIntro(reader1.readLine());	//���ļҰ� �б�
				foodInfo.setFoodPhoto(reader1.readLine());	//���Ļ��� ��� �б�
				try
				{
					foodInfo.setFoodCalorie(Integer.parseInt(reader1.readLine()));//����Į�θ��б�
				}
				catch(NumberFormatException e)
				{
				}
	
				foodInfoList.addFoodInfoList(foodInfo); //FoodInfoList�� ����
			}
			//-------- �����׽�Ʈ ----
/*			FoodInfo food = new FoodInfo();
			LinkedList<FoodInfo> list5 = (LinkedList<FoodInfo>)foodInfoList.getFoodInfoList();
			Iterator<FoodInfo> iterator = list5.iterator();
			while(iterator.hasNext())
			{
				food = iterator.next();
				System.out.println(food.getFoodCalorie());
			}
*/
			
//---------------------------------���� �̻�----------------------------------------
			
			reader2 = new BufferedReader(new FileReader("CookingCourseListData.txt"));

			while(true)
			{
				String foodCode = reader2.readLine();
				//CookingCourseList cookingCourseList = new CookingCourseList();
				CookingCourseList cookingCourseList = new CookingCourseList();

				if(foodCode == null){break;}
				if(foodCode.equals("����")){
					foodCode = reader2.readLine();
				}
				cookingCourseList.setFoodCode(foodCode);
				cookingCourseList.setFoodName(reader2.readLine());
				while(true)
				{
					CookingCourse cookingCourse = new CookingCourse();
					String delimeter = reader2.readLine();
					if(delimeter == null){break;}
					if(delimeter.equals("����")){break;}
					cookingCourse.setCookingPhoto(delimeter);
					try
					{
						cookingCourse.setCookingTime(Integer.parseInt(reader2.readLine()));
					}
					catch(NumberFormatException e)
					{
					}
					cookingCourse.setCookingInst(reader2.readLine());
					cookingCourseList.addCookingCourse(cookingCourse);
				}
				cookingCourseListData.addCookingCourseList(cookingCourseList);
			}
//----------------------------------------- �� �������� �̻� -------------------------

//*------------ �����׽�Ʈ ---------
	/*		CookingCourseList cook1 = new CookingCourseList();
			CookingCourse co = new CookingCourse();

			LinkedList<CookingCourseList> list7 = (LinkedList<CookingCourseList>)cookingCourseListData.getCookingCourseListData();

			Iterator<CookingCourseList> iterator = list7.iterator();
			
			//LinkedList<CookingCourse> la = (LinkedList<CookingCourse>)

			while(iterator.hasNext())
			{
				cook1 = iterator.next();
				System.out.println(cook1.getFoodCode());
				System.out.println(cook1.getFoodName());
				LinkedList<CookingCourse> ls = (LinkedList<CookingCourse>)cook1.getCookingCourseList();
				Iterator<CookingCourse> it = ls.iterator();
				while(it.hasNext())
				{
					co = it.next();
					System.out.println(co.getCookingPhoto());
					System.out.println(co.getCookingTime());
					System.out.println(co.getCookingInst());
				}
			}

*/


			reader3 = new BufferedReader(new FileReader("RecipeIngreInfoData.txt"));
	
			while(true)
			{
				String foodCode = reader3.readLine();
				RecipeIngreInfoList recipeIngreInfoList = new RecipeIngreInfoList();

				if(foodCode == null){break;}
				if(foodCode.equals("����")){
					foodCode = reader3.readLine();
				}
				recipeIngreInfoList.setFoodCode(foodCode);
				recipeIngreInfoList.setFoodName(reader3.readLine());
				while(true)
				{
					RecipeIngreInfo recipeIngreInfo = new RecipeIngreInfo();
					String delimeter = reader3.readLine();
					if(delimeter == null){break;}
					if(delimeter.equals("����")){break;}
					recipeIngreInfo.setIngredientCode(delimeter);						recipeIngreInfo.setIngredientName(reader3.readLine());
					try
					{
						recipeIngreInfo.setIngredientNum(Integer.parseInt(reader3.readLine()));
					}
					catch(NumberFormatException e)
					{}
					recipeIngreInfoList.addRecipeIngreInfoList(recipeIngreInfo);
				}
				recipeIngreInfoListData.addRecipeIngreInfoList(recipeIngreInfoList);
			}
//---------------------------------- �� ������ �����׽�Ʈ �Ϸ� �̻� ---------------------

/*		-- �����׽�Ʈ --
			RecipeIngreInfoList ingre5 = new RecipeIngreInfoList();
			RecipeIngreInfo re5 = new RecipeIngreInfo();

			LinkedList<RecipeIngreInfoList> list5 = (LinkedList<RecipeIngreInfoList>)recipeIngreInfoListData.getRecipeIngreInfoList();

			Iterator<RecipeIngreInfoList> iter5 = list5.iterator();
			while(iter5.hasNext())
			{
				ingre5 = iter5.next();
				System.out.println(ingre5.getFoodCode());
				System.out.println(ingre5.getFoodName());
				LinkedList<RecipeIngreInfo> io = (LinkedList<RecipeIngreInfo>)ingre5.getRecipeIngreInfoList();
				Iterator<RecipeIngreInfo> i2 = io.iterator();
				while(i2.hasNext())
				{
					re5 = i2.next();
					System.out.println(re5.getIngredientCode());
					System.out.println(re5.getIngredientName());
					System.out.println(re5.getIngredientNum());
				}

			}
*/

			reader4 = new BufferedReader(new FileReader("RecipeInfoData.txt"));
			CookingCourseList cook = new CookingCourseList();//temp
			LinkedList<CookingCourseList> list = (LinkedList<CookingCourseList>)cookingCourseListData.getCookingCourseListData();
			Iterator<CookingCourseList> iter = list.iterator();

			RecipeIngreInfoList ingre = new RecipeIngreInfoList();
			LinkedList<RecipeIngreInfoList> list2 =
			(LinkedList<RecipeIngreInfoList>)recipeIngreInfoListData.getRecipeIngreInfoList();
			Iterator<RecipeIngreInfoList> iter2 = list2.iterator();
			
			while(true)
			{
				String foodCode = reader4.readLine();
				RecipeInfo recipeInfo = new RecipeInfo();
				try
				{
					cook = iter.next();
					ingre = iter2.next();
				}catch(NoSuchElementException e)
				{}
				
				if(foodCode == null){break;}
				recipeInfo.setFoodCode(foodCode);
				recipeInfo.setFoodName(reader4.readLine());
				try
				{
					recipeInfo.setCookingTotalTime(Integer.parseInt(reader4.readLine()));
				}
				catch(NumberFormatException e)
				{
				}
				recipeInfo.setTip(reader4.readLine());
				try
				{
					recipeInfo.setPortion(Integer.parseInt(reader4.readLine()));
				}
				catch(NumberFormatException e)
				{
				}
				reader4.readLine();

				//recipeInfo.setLevel(Level.valueOf(reader4.readLine()));
				recipeInfo.setCookingCourseList(cook);
				recipeInfo.setRecipeIngreInfoList(ingre);

				recipeInfoList.addRecipeInfoList(recipeInfo);
			}

		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				reader1.close();
				reader2.close();
				reader3.close();
				reader4.close();
			}
			catch (Exception e)
			{
				System.out.println("���� �ݱ� ����");
			}
		}

	}
	public void writerFoodInfo()
	{
	}
	public void load()
	{
		LinkedList<FoodInfo> list = (LinkedList<FoodInfo>)foodInfoList.getFoodInfoList();
		Iterator<FoodInfo> iter = list.iterator();

		LinkedList<RecipeInfo> list2 = (LinkedList<RecipeInfo>)recipeInfoList.getRecipeInfoList();
		Iterator<RecipeInfo> iter2 = list2.iterator();
		
		FoodInfo info = new FoodInfo();
		RecipeInfo info2 = new RecipeInfo();

		while(iter.hasNext())
		{
			info = iter.next();
			info2 = iter2.next();
			FoodRecipeInfo foodRecipeInfo = new FoodRecipeInfo();
			foodRecipeInfo.setFoodInfo(info);
			foodRecipeInfo.setRecipeInfo(info2);
			
			System.out.println(foodRecipeInfo.getFoodInfo().getFoodName());
			 if(foodRecipeInfo.getFoodInfo().getFoodName() == null){break;}
			FoodRecipeInfoList.addFoodRecipeInfoList(foodRecipeInfo);
		}



	}
}
