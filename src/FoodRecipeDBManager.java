/*
	�ۼ���  : ��ȫ��
	Class�� : FoodRecipeDBManager
*/

import java.io.*;
import java.util.*;

public class FoodRecipeDBManager 
{
	private CookingCourseListData cookingCourseListData;
	private RecipeIngreInfoListData recipeIngreInfoListData;//����
	private RecipeInfoList recipeInfoList;
	private FoodInfoList foodInfoList;

	//------------------------------- constructor -----------------------------------------
	public FoodRecipeDBManager()
	{
		this(new CookingCourseListData(),new RecipeIngreInfoListData(),new RecipeInfoList(),new FoodInfoList());
		
		readFoodInfo();
		
		readCookingCourse();
		
		readIngredient();
	
		readRecipe();
		
		load();
		
	}
	public FoodRecipeDBManager(CookingCourseListData cookingCourseListData,RecipeIngreInfoListData recipeIngreInfoListData,RecipeInfoList recipeInfoList,FoodInfoList foodInfoList)
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
		FoodList foodList = null;		//DAOList
		FoodDAO foodDAO = new FoodDAO();//DAO��ü ����.
		foodList = foodDAO.selectAll(); //table��� ������ �����´�.
		foodDAO.disconnect();
		Iterator<FoodDTO> iterator = foodList.getFoodList().iterator();
		while(iterator.hasNext())
		{
			FoodInfo foodInfo = new FoodInfo(); //�� info
			FoodDTO temp = iterator.next(); //�ӽ� DTO��ü
			
			foodInfo.setFoodCode(Integer.toString(temp.getFoodCode()));
			foodInfo.setFoodName(temp.getFoodName());
			foodInfo.setFoodIntro(temp.getFoodIntro());
			foodInfo.setFoodPhoto(temp.getFoodPhoto());
			foodInfo.setFoodCalorie(temp.getFoodCal());

			foodInfoList.addFoodInfoList(foodInfo); //foodInfoList�� �߰��߰�
		}
		
/*		Iterator<FoodInfo> iter = foodInfoList.getFoodInfoList().iterator();
		while(iter.hasNext())
		{
			FoodInfo info = iter.next();
			System.out.println(info.getFoodName());
		}*/

	}
	public void readCookingCourse()
	{
		CourseList courseList = null;

		RecipeCourseDAO courseDAO = new RecipeCourseDAO(); 
		courseList = courseDAO.selectCourse();
		courseDAO.disconnect();
		

		Iterator<CourseDTO> iterator = courseList.getCourseList().iterator();
		
		int tmp = 0;
		CookingCourseList cookingCourseList = null;//�ڵ�ٲ𶧻���

		while(iterator.hasNext())
		{
			CourseDTO temp = iterator.next();
			if(tmp < temp.getFoodCode())
			{
				if(tmp != 0)
				{
					cookingCourseListData.addCookingCourseList(cookingCourseList);
				}
				tmp = temp.getFoodCode();
				cookingCourseList = new CookingCourseList();
			}
			int foodCode = temp.getFoodCode();
			cookingCourseList.setFoodCode(Integer.toString(foodCode));
			cookingCourseList.setFoodName(temp.getFoodName());
			
			CookingCourse cookingCourse = new CookingCourse();
			cookingCourse.setCookingPhoto(temp.getRecipeCoursePhoto());
			cookingCourse.setCookingTime(temp.getRecipeCourseTime());
			cookingCourse.setCookingInst(temp.getRecipeCourseIntro());
			cookingCourseList.addCookingCourse(cookingCourse);
		}

	}
	public void readIngredient()
	{
		RecipeIngreInfoDTOList recipeIngreInfoDTOList = null;
		RecipeIngredientDAO ingreDAO = new RecipeIngredientDAO();
		recipeIngreInfoDTOList = ingreDAO.selectIngre();
		ingreDAO.disconnect();

		Iterator<RecipeIngreInfoDTO> iterator = recipeIngreInfoDTOList.getRecipeIngreInfoList().iterator();
		
		int tmp = 0;
		RecipeIngreInfoList recipeIngreInfoList = null;//�ڵ�ٲ𶧻���

		while(iterator.hasNext())
		{
			RecipeIngreInfoDTO temp = iterator.next();
			if(tmp < temp.getFoodCode())
			{
				if(tmp != 0)
				{
					recipeIngreInfoListData.addRecipeIngreInfoList(recipeIngreInfoList);
				}
				tmp = temp.getFoodCode();
				recipeIngreInfoList = new RecipeIngreInfoList();
			}
			int foodCode = temp.getFoodCode();
			recipeIngreInfoList.setFoodCode(Integer.toString(foodCode));
			recipeIngreInfoList.setFoodName(temp.getFoodName());
			
			RecipeIngreInfo recipeIngreInfo = new RecipeIngreInfo();
			recipeIngreInfo.setIngredientName(temp.getIngredientName());
			recipeIngreInfo.setIngredientCode(Integer.toString(temp.getIngredientCode()));
			recipeIngreInfo.setIngredientNum(temp.getIngredientNum());
			recipeIngreInfoList.addRecipeIngreInfoList(recipeIngreInfo);
		}
		
	}
	public void readRecipe()
	{
		RecipeList recipeList = null;
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeList = recipeDAO.selectAll();
		recipeDAO.disconnect();
		Iterator<RecipeDTO> iterator = recipeList.getRecipeList().iterator();
	
		CookingCourseList cook = new CookingCourseList();//temp
		LinkedList<CookingCourseList> list = (LinkedList<CookingCourseList>)cookingCourseListData.getCookingCourseListData();
		Iterator<CookingCourseList> iter = list.iterator();
		
		RecipeIngreInfoList ingre = new RecipeIngreInfoList();
		LinkedList<RecipeIngreInfoList> list2 =(LinkedList<RecipeIngreInfoList>)recipeIngreInfoListData.getRecipeIngreInfoList();
		Iterator<RecipeIngreInfoList> iter2 = list2.iterator();
		
		FoodDAO foodDAO = new FoodDAO();
		while(iter.hasNext())
		{
			RecipeDTO temp = iterator.next();
			RecipeInfo recipeInfo = new RecipeInfo();
			cook = iter.next();
			ingre = iter2.next();
			
			
			FoodDTO foodDTO = foodDAO.selectFoodCode(temp.getFoodCode());
			recipeInfo.setFoodCode(Integer.toString(temp.getFoodCode()));
			recipeInfo.setFoodName(foodDTO.getFoodName());
			recipeInfo.setCookingTotalTime(temp.getRecipeTime());
			recipeInfo.setTip(temp.getTip());
			recipeInfo.setPortion(temp.getPortion());
			recipeInfo.setCookingCourseList(cook);
			recipeInfo.setRecipeIngreInfoList(ingre);
	
			recipeInfoList.addRecipeInfoList(recipeInfo);
			
		}
		foodDAO.disconnect();
		
		

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

		while(iter2.hasNext())
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
