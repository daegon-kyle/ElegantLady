/*
	작성자 : 장성봉
	클래스명 : 수령인정보 // RecipientInfo 
*/
public class RecipientInfo
{
	private String recipientName;
	private String recipientPhone;
	private String recipientAddress;
	public RecipientInfo()
	{
		this("","","");
	}
	public RecipientInfo(String recipientName,String recipientPhone,String recipientAddress)
	{
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientName()
	{
		return this.recipientName;
	}
	public String getRecipientPhone()
	{
		return this.recipientPhone;
	}
	public String getRecipientAddress()
	{
		return this.recipientAddress;
	}
	public void setRecipeintName(String recipientName)
	{
		this.recipientName =recipientName;
	}
	public void setRecipeintPhone(String recipientPhone)
	{
		this.recipientPhone =recipientPhone;
	}
	public void setRecipeintAddress(String recipientAddress)
	{
		this.recipientAddress =recipientAddress;
	}
}