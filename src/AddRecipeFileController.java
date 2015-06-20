
import java.io.*;
import java.util.*;
//레시피를 파일에 추가 등록하는 컨트롤러
class AddRecipeFileController
{
	private File foodFile;
	private File recipeIngreFile;
	private File recipeFile;
	private File CookingCourseFile;
	public FoodInfo foodInfo;
	public RecipeInfo recipeInfo;

	public AddRecipeFileController()
	{
		this(new File("FoodInfoData.txt")
			,new File("RecipeIngreInfoData.txt")
			,new File("RecipeInfoData.txt")
			,new File("CookingCourseListData.txt")
			,new FoodInfo(),new RecipeInfo());
	}
	public AddRecipeFileController(File foodFile,File recipeIngreFile,File recipeFile,File CookingCourseFile,FoodInfo foodInfo,RecipeInfo recipeInfo)
	{
		this.foodFile = foodFile;
		this.recipeIngreFile =recipeIngreFile;
		this.recipeFile =recipeFile;
		this.CookingCourseFile =CookingCourseFile;
		this.foodInfo = foodInfo;
		this.recipeInfo = recipeInfo;
	}
	public AddRecipeFileController(FoodInfo foodInfo,RecipeInfo recipeInfo)
	{
		this(new File("FoodInfoData.txt")
			,new File("RecipeIngreInfoData.txt")
			,new File("RecipeInfoData.txt")
			,new File("CookingCourseListData.txt")
			,foodInfo,recipeInfo);
	}
	//FoodInfo 클래스 내용을 저장하는 메소드
	public void writeFoodInfoFile()
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(foodFile,true));
			writeFoodInfoFile(writer,foodInfo);
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 할 수 없습니다.");
		}		
		finally
		{
			try
			{
				writer.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	//RecipeIngreInfo 클래스 내용을 저장하는 메소드
	public void writeRecipeIngreInfoFile()
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(recipeIngreFile,true));
			writer.write(foodInfo.getFoodCode(),0,foodInfo.getFoodCode().length());
			writer.newLine();
			writer.write(foodInfo.getFoodName(),0,foodInfo.getFoodName().length());
			writer.newLine();
			for(RecipeIngreInfo cnt : TempRecipeIngreInfoList.getRecipeIngreInfoList())
			{
				writeRecipeIngreInfoFile(writer,cnt);
			}
			writer.newLine();
			writer.write("구분",0,2);
			writer.newLine();
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 할 수 없습니다.");
		}		
		finally
		{
			try
			{
				writer.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}		
	}
	//RecipeInfo 클래스 내용을 저장하는 메소드
	public void writeRecipeInfoFile()
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(recipeFile,true));
			writeRecipeInfoFile(writer,recipeInfo);
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 할 수 없습니다.");
		}		
		finally
		{
			try
			{
				writer.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	//CookingCourseList내용을 저장하는 메소드
	public void writeCookingCourseListFile()
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(CookingCourseFile,true));
			writer.write(foodInfo.getFoodCode(),0,foodInfo.getFoodCode().length());
			writer.newLine();
			writer.write(foodInfo.getFoodName(),0,foodInfo.getFoodName().length());
			writer.newLine();
			for(CookingCourse cnt : TempCookingCourseList.getCookingCourseList())
			{
				writeCookingCourseListFile(writer,cnt);
			}
			writer.write("구분",0,2);
			writer.newLine();
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 할 수 없습니다.");
		}		
		finally
		{
			try
			{
				writer.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	private void writeFoodInfoFile(BufferedWriter pw,FoodInfo foodInfo)
	{
		try
		{
			pw.write(foodInfo.getFoodCode(),0,foodInfo.getFoodCode().length());	
			pw.newLine();
			pw.write(foodInfo.getFoodName(),0,foodInfo.getFoodName().length());	
			pw.newLine();
			pw.write(foodInfo.getFoodIntro(),0,foodInfo.getFoodIntro().length());	
			pw.newLine();
			pw.write(foodInfo.getFoodPhoto(),0,foodInfo.getFoodPhoto().length());
			pw.newLine();
			pw.write(Integer.toString(foodInfo.getFoodCalorie()),0,Integer.toString(foodInfo.getFoodCalorie()).length());
			pw.newLine();
			pw.flush();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}		
	}
	private void writeRecipeInfoFile(BufferedWriter pw,RecipeInfo recipeInfo)
	{
		try
		{
			pw.write(foodInfo.getFoodCode(),0,foodInfo.getFoodCode().length());	
			pw.newLine();
			pw.write(foodInfo.getFoodName(),0,foodInfo.getFoodName().length());	
			pw.newLine();
			pw.write(Integer.toString(recipeInfo.getCookingTotalTime()),0,Integer.toString(recipeInfo.getCookingTotalTime()).length());	
			pw.newLine();
			pw.write(recipeInfo.getTip(),0,recipeInfo.getTip().length());
			pw.newLine();
			pw.write(Integer.toString(recipeInfo.getPortion()),0,Integer.toString(recipeInfo.getPortion()).length());
			pw.newLine();
			pw.write(recipeInfo.getLevel().value(),0,recipeInfo.getLevel().value().length());
			pw.newLine();
			pw.flush();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private void writeRecipeIngreInfoFile(BufferedWriter pw,RecipeIngreInfo recipeIngre)
	{
		try
		{
			//System.out.println("코드다"+recipeIngre.getIngredientCode());
			pw.write(recipeIngre.getIngredientCode(),0,recipeIngre.getIngredientCode().length());	
			pw.newLine();
			pw.write(recipeIngre.getIngredientName(),0,recipeIngre.getIngredientName().length());	
			pw.newLine();
			pw.write(Integer.toString(recipeIngre.getIngredientNum()),0,Integer.toString(recipeIngre.getIngredientNum()).length());
			pw.flush();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private void writeCookingCourseListFile(BufferedWriter pw,CookingCourse cookingCourse)
	{
		
		try
		{
			pw.write(cookingCourse.getCookingPhoto(),0,cookingCourse.getCookingPhoto().length());	
			pw.newLine();
			pw.write(Integer.toString(cookingCourse.getCookingTime()),0,Integer.toString(cookingCourse.getCookingTime()).length());	
			pw.newLine();
			pw.write(cookingCourse.getCookingInst(),0,cookingCourse.getCookingInst().length());	
			pw.newLine();
			pw.flush();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}	
}
