/*
작성자명 : 김대곤
클래스명 : 판매물품정보
*/
public class SoldItemInfo 
{
	private String soldItemName;
	private int soldItemNum;
	private String soldItemCode;
	private String placeOfOrisin;
	private double price;

	public SoldItemInfo()
	{
		this("",0,"","",0.0);
	}
	public SoldItemInfo(String soldItemName, int soldItemNum, String soldItemCode, String placeOfOrisin, double price)
	{
		this.soldItemName=soldItemName;
		this.soldItemNum=soldItemNum;
		this.soldItemCode=soldItemCode;
		this.placeOfOrisin=placeOfOrisin;
		this.price=price;
	}

	public String getSoldItemName()
	{
		return soldItemName;
	}
	public int getSoldItemNum()
	{
		return soldItemNum;
	}
	public String getSoldItemCode()
	{
		return soldItemCode;
	}
	public String getPlaceOfOrisin()
	{
		return placeOfOrisin;
	}
	public double getPrice()
	{
		return price;
	}
	public void setSoldItemName(String soldItemName)
	{
		this.soldItemName=soldItemName;
	}
	public void setSoldItemNum(int soldItemNum)
	{
		this.soldItemNum=soldItemNum;
	}
	public void setSoldItemCode(String sodlItemCode)
	{
		this.soldItemCode=soldItemCode;
	}
	public void setPlaceOfOrisin(String placeOfOrisin)
	{
		this.placeOfOrisin=placeOfOrisin;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
}
