/*
	작성자 : 장성봉
	클래스명 : 배송정보 //DeliveryInfo
*/
public class DeliveryInfo
{
	private String date;
	private String deliveryTime;
	private DeliveryState deliveryState;
	private String deliveryAddress;
	private double price;
	public DeliveryInfo()
	{
		this("","",DeliveryState.PREPARATION,"",0.0);
	}
	public DeliveryInfo(String date,String deliveryTime,DeliveryState deliveryState,String deliveryAddress,double price)
	{
		this.date =date;
		this.deliveryTime= deliveryTime;
		this.deliveryState = deliveryState;
		this.deliveryAddress = deliveryAddress;
		this.price = price;
	}
	public String getDate()
	{
		return this.date;
	}
	public String getDeliveryTime()
	{
		return this.deliveryTime;
	}
	public DeliveryState getDeliveryState()
	{
		return this.deliveryState;
	}
	public String getDeliveryAddress()
	{
		return this.deliveryAddress;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public void setDeliveryTime(String deliveryTime)
	{
		this.deliveryTime = deliveryTime;
	}
	public void setDeliveryState(DeliveryState deliveryState)
	{
		this.deliveryState = deliveryState;
	}
	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress= deliveryAddress;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
}