//  @ File Name : StoreItemInfo.java
//  @ Date : 2014-04-28
//  @ Author : ±è¿µÇÑ

public class StoreItemInfo {
	private StoreInfo storeInfo;
	private SoldItemInfoList soldItemInfoList;
	public StoreItemInfo() {
		this(new StoreInfo(), new SoldItemInfoList());
	}
	
	public StoreItemInfo(StoreInfo storeInfo, SoldItemInfoList soldItemInfoList) {
		this.storeInfo = storeInfo;
		this.soldItemInfoList = soldItemInfoList;
	}
	
	public StoreInfo getStoreInfo() {
		return storeInfo;
	}
	
	public SoldItemInfoList getSoldItemInfoList() {
		return soldItemInfoList;
	}
	
	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	
	public void setSoldItemInfoList(SoldItemInfoList soldItemInfoList) {
		this.soldItemInfoList = soldItemInfoList;
	}
}
