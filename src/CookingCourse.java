//양진영
//조리과정(1개)
public class CookingCourse
{
	private String cookingPhoto;
	private int cookingTime;
	private String cookingInst;

	public CookingCourse()
	{
		this("",0,"");
	}
	public CookingCourse(int cookingTime,String cookingInst)
	{
		this("",cookingTime,cookingInst);
	}
	public CookingCourse(String cookingPhoto,int cookingTime,String cookingInst)
	{
		this.cookingPhoto=cookingPhoto;
		this.cookingTime=cookingTime;
		this.cookingInst=cookingInst;
	}
	public String getCookingPhoto()
	{
		return cookingPhoto;
	}
	public int getCookingTime()
	{
		return this.cookingTime;
	}
	public String getCookingInst()
	{
		return this.cookingInst;
	}
	public void setCookingPhoto(String cookingPhoto)
	{
		this.cookingPhoto=cookingPhoto;
	}
	public void setCookingTime(int cookingTime)
	{
		this.cookingTime=cookingTime;
	}
	public void setCookingInst(String cookingInst)
	{
		this.cookingInst=cookingInst;
	}

}  