/*
작성자명 : 김대곤
클래스명 : 개인정보
*/
public class Profile 
{
	private String name;
	private String address;
	private String phone;
	private String zipCode;

	public Profile()
	{
		this("","","","");
	}
	public Profile(String name, String address, String phone, String zipeCode)
	{
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.zipCode=zipCode;
	}

	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode=zipCode;
	}
}
