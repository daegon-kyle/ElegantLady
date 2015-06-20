/*
	작성자 : 장성봉
	클래스명 : 회원 정보 // MemberInfo
*/
public class MemberInfo
{
	private String name;
	private String id;
	private String password;
	private String address;
	private String phone;
	private String zipCode;
	public MemberInfo()
	{
		this("","","","","","");
	}
	public MemberInfo(String name,String id)
	{
		this(name,id,"","","","");
	}
	public MemberInfo(String name,String id,String password,String address,String phone,String zipCode)
	{
		this.name = name;
		this.id = id;
		this.password= password;
		this.address =address;
		this.phone =phone;
		this.zipCode = zipCode;
	}
	public String getName()
	{
		return this.name;
	}
	public String getId()
	{
		return this.id;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getAddress()
	{
		return this.address;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getZipCode()
	{
		return this.zipCode;
	}
	public void setName(String name)
	{
		this.name= name;
	}
	public void setId(String id)
	{
		this.id= id;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
}