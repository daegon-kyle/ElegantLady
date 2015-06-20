//양진영
//한개 음식당 요리과정목록
import java.util.*;
public class CookingCourseList 
{
	private Collection<CookingCourse> cookingCourseList;
	private String foodName;
	private String foodCode;

	public CookingCourseList()
	{
		this(new LinkedList<CookingCourse>(),"","");
	}
	public CookingCourseList(Collection<CookingCourse> cookingCourseList,String foodName,String foodCode)
	{
		this.cookingCourseList=cookingCourseList;
		this.foodName=foodName;
		this.foodCode=foodCode;
	}
	public CookingCourseList(String foodName,String foodCode)
	{
		this(new LinkedList<CookingCourse>(),foodName,foodCode);
	}
	public Collection<CookingCourse> getCookingCourseList()
	{
		return this.cookingCourseList;
	}
	public String getFoodName()
	{
		return this.foodName;
	}
	public String getFoodCode()
	{
		return this.foodCode;
	}
	public void setCookingCourseList(Collection<CookingCourse> cookingCourseList)
	{
		this.cookingCourseList=cookingCourseList;
	}
	public void setFoodName(String foodName)
	{
		this.foodName=foodName;
	}
	public void setFoodCode(String foodCode)
	{
		this.foodCode=foodCode;
	}
	//추가
	public CookingCourse addCookingCourse(CookingCourse cookingCourse)
	{
		cookingCourseList.add(cookingCourse);
		return cookingCourse;
	}
	public CookingCourse addCookingCourse(String cookingPhoto,int cookingTime,String cookingInst)
	{
		CookingCourse cookingCourse=new CookingCourse(cookingPhoto,cookingTime,cookingInst);
		cookingCourseList.add(cookingCourse);
		return cookingCourse;
	}
	//검색(번호)
	public CookingCourse searchCookingCourse(int step)
	{
		try
		{
			return ((LinkedList<CookingCourse>)cookingCourseList).get(step);
		}
		catch (IndexOutOfBoundsException iooe)
		{
			return null;
		}
	}
	public CookingCourse searchCookingCourse(CookingCourse cookingCourse)
	{
		int i=0;
		for(CookingCourse tmp:cookingCourseList)
		{
			if(tmp.getCookingPhoto().equals(cookingCourse.getCookingPhoto()))
			{
				if(tmp.getCookingTime()==cookingCourse.getCookingTime())
				{
					if(tmp.getCookingInst().equals(cookingCourse.getCookingInst()))
					{
						break;
					}
				}
			}
			i++;
		}
		if(i>cookingCourseList.size())
			return null;
		else
			return ((LinkedList<CookingCourse>)cookingCourseList).get(i);
	}
	//삭제
	public CookingCourse removeCookingCourse(CookingCourse cookingCourse)
	{
		CookingCourse tmp=searchCookingCourse(cookingCourse);
		if(cookingCourseList.remove(tmp))
		{
			return tmp;
		}
		else
		{
			return null;
		}
	}
	public CookingCourse removeCookingCourse(int step)
	{
		CookingCourse tmp=searchCookingCourse(step);
		if(cookingCourseList.remove(tmp))
		{
			return tmp;
		}
		else
		{
			return null;
		}
	}
	//수정
	public CookingCourse reviseCookingCourse(CookingCourse searchData,CookingCourse reviseData)
	{
		int i=0;
		for(CookingCourse tmp:cookingCourseList)
		{
			if(tmp.getCookingPhoto().equals(searchData.getCookingPhoto()))
			{
				if(tmp.getCookingTime()==searchData.getCookingTime())
				{
					if(tmp.getCookingInst().equals(searchData.getCookingInst()))
					{
						((LinkedList<CookingCourse>)cookingCourseList).set(i,reviseData);
						return reviseData;
					}
				}
			}
			i++;
		}
		return null;
	}
	public CookingCourse reviseCookingCourse(int step,CookingCourse reviseData)
	{
		try
		{
			return ((LinkedList<CookingCourse>)cookingCourseList).set(step,reviseData);	
		}
		catch (IndexOutOfBoundsException e)
		{
			return null;
		}
	}
}
