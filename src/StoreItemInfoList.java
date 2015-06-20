//  @ File Name : StoreItemInfoList.java
//  @ Date : 2014-04-28
//  @ Author : ±è¿µÇÑ 
//
//
import java.util.*;
public class StoreItemInfoList {
	private static Collection<StoreItemInfo> storeItemInfoList;

	static
	{
		storeItemInfoList = new LinkedList<StoreItemInfo>();
	}

	public static Collection<StoreItemInfo> getStoreItemInfoList() {
		return storeItemInfoList;
	}
	
	public static void setStoreItemInfoList(Collection<StoreItemInfo> storeItemInfoList) {
		StoreItemInfoList.storeItemInfoList = storeItemInfoList;
	}
	
	public static StoreItemInfo addStoreItemInfoList(StoreItemInfo storeItemInfo) {
		storeItemInfoList.add(storeItemInfo);
		return storeItemInfo;
	}
	
	public static StoreItemInfo reviseStoreItemInfoList(String storeCode, StoreItemInfo storeItemInfo) {
		StoreItemInfo info = StoreItemInfoList.searchStoreItemInfo(storeCode);
		if(info != null)
		{
			int index = ((LinkedList<StoreItemInfo>)storeItemInfoList).indexOf(info);
			if(index != -1)
			{	
				((LinkedList<StoreItemInfo>)storeItemInfoList).set(index,storeItemInfo);
				return storeItemInfo;
			}
		}
		return null;
	}

	public static StoreItemInfo reviseStoreItemInfoList(StoreItemInfo oldStoreItemInfo, StoreItemInfo newStoreItemInfo) {
		int index = ((LinkedList<StoreItemInfo>)storeItemInfoList).indexOf(oldStoreItemInfo);
		if(index != -1)
		{
			((LinkedList<StoreItemInfo>)storeItemInfoList).set(index,newStoreItemInfo);
			return newStoreItemInfo;
		}
		return null;
	}
	
	public static StoreItemInfo removeStoreItemInfoList(String storeCode) {
		StoreItemInfo storeItemInfo = StoreItemInfoList.searchStoreItemInfo(storeCode);
		if(storeItemInfo != null)
		{
			storeItemInfoList.remove(storeItemInfo);
			return storeItemInfo;
		}
		return null;
	}
	
	public static StoreItemInfo searchStoreItemInfo(String storeCode) {
		for(StoreItemInfo storeItemInfo : storeItemInfoList)
		{
			if(storeItemInfo.getStoreInfo().getStoreCode().equals(storeCode))
				return storeItemInfo;
		}
		return null;
	}

	public static Collection<StoreItemInfo> searchStoreItemInfoList(String storeName){
		Collection<StoreItemInfo> list = new LinkedList<StoreItemInfo>();
		for(StoreItemInfo storeItemInfo : storeItemInfoList)
		{
			if(storeItemInfo.getStoreInfo().getStoreCode().equals(storeName))
				list.add(storeItemInfo);
		}
		return list;
	}
}
