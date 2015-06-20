//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : StoreList.java
//  @ Date : 2014-05-13
//  @ Author : 
//
//
import java.util.*;

public class StoreList 
{
	private Collection<StoreDTO> storeList;
	public StoreList() 
	{
		this(new LinkedList<StoreDTO>());
	}
	public StoreList(Collection<StoreDTO> storeList) 
	{
		this.storeList = storeList;
	}
	public StoreDTO addStoreList(StoreDTO storeDTO) 
	{
		storeList.add(storeDTO);
		return storeDTO;
	}
	public StoreDTO removeStoreList(StoreDTO storeDTO) 
	{
		StoreDTO temp = searchStoreList(storeDTO);
		if(temp != null)
		{
			storeList.remove(temp);
			return temp;
		}
		return null;
	}
	public StoreDTO reviseStoreList(StoreDTO exStoreDTO, StoreDTO newStoreDTO) 
	{
		int i = 0;
		for(StoreDTO temp : storeList)
		{
			if(temp.getStoreCode() == exStoreDTO.getStoreCode())
			{
				((LinkedList<StoreDTO>) storeList).set(i,newStoreDTO);
			}
			i++;
		}
		return newStoreDTO;
	
	}
	public StoreDTO searchStoreList(StoreDTO storeDTO) 
	{
		for(StoreDTO temp : storeList)
		{
			if(temp.getStoreCode()==storeDTO.getStoreCode())
			{
				return temp;
			}
		}
		return null;
	}
	public Collection<StoreDTO> getStoreList()
	{
		return storeList;
	}
	public void setStoreList(Collection<StoreDTO> storeList)
	{
		this.storeList=storeList;
	}
}
