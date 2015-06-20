public class CourseDTO 
{
	private int foodCode;
	private String foodName;
	private String recipeCoursePhoto;
	private int recipeCourseTime;
	private String recipeCourseIntro;

	public CourseDTO()
	{
		this(0,null,null,0,null);
	}
	public CourseDTO(int foodCode,String foodName,String recipeCoursePhoto,int recipeCourseTime,String recipeCourseIntro)
	{
		this.foodCode = foodCode;
		this.foodName = foodName;
		this.recipeCoursePhoto = recipeCoursePhoto;
		this.recipeCourseTime = recipeCourseTime;
		this.recipeCourseIntro = recipeCourseIntro;
	}
	public int getFoodCode()
	{
		return foodCode;
	}
	public String getFoodName()
	{
		return foodName;
	}
	public String getRecipeCoursePhoto()
	{
		return recipeCoursePhoto;
	}
	public int getRecipeCourseTime()
	{
		return recipeCourseTime;
	}
	public String getRecipeCourseIntro()
	{
		return this.recipeCourseIntro;
	}

	public void setFoodCode(int foodCode)
	{
		this.foodCode = foodCode;
	}
	public void setFoodName(String foodName)
	{
		this.foodName = foodName;
	}
	public void setRecipeCoursePhoto(String recipeCoursePhoto)
	{
		this.recipeCoursePhoto = recipeCoursePhoto;
	}
	public void setRecipeCourseTime(int recipeCourseTime)
	{
		this.recipeCourseTime = recipeCourseTime;
	}
	public void setRecipeCourseIntro(String recipeCourseIntro)
	{
		this.recipeCourseIntro = recipeCourseIntro;
	}
	public String toString()
	{
		return "คว";
	}
}
