//양진영
//판매처정보
public class StoreInfo
{
	private String storeName;
	private String storeCode;
	private String storeAddress;
	private String storePhone;

	public StoreInfo()
	{
		this("","","","");
	}
	public StoreInfo(String storeName,String storeCode,String storeAddress,String storePhone)
	{
		this.storeName=storeName;
		this.storeCode=storeCode;
		this.storeAddress=storeAddress;
		this.storePhone=storePhone;
	}
	public String getStoreName()
	{
		return storeName;
	}
	public String getStoreCode()
	{
		return storeCode;
	}
	public String getStoreAddress()
	{
		return storeAddress;
	}
	public String getStorePhone()
	{
		return storePhone;
	}
	public void setStoreName(String storeName)
	{
		this.storeName=storeName;
	}
	public void setStoreCode(String storeCode)
	{
		this.storeCode=storeCode;
	}
	public void setStoreAddress(String storeAddress)
	{
		this.storeAddress=storeAddress;
	}
	public void setStorePhone(String storePhone)
	{
		this.storePhone=storePhone;
	}
}