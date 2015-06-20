/*
작성자명 : 김대곤
클래스명 : 판매물품정보리스트
*/
import java.util.*;
public class SoldItemInfoList 
{
	private Collection<SoldItemInfo> soldItemInfoList;

	public SoldItemInfoList()
	{
		this(new LinkedList<SoldItemInfo>());
	}
	public SoldItemInfoList(Collection<SoldItemInfo> soldItemInfoList)
	{
		this.soldItemInfoList=soldItemInfoList;
	}

	public Collection<SoldItemInfo> getSoldItemInfoList()
	{
		return soldItemInfoList;
	}
	public void setSoldItemInfoList(Collection<SoldItemInfo> soldItemInfoList)
	{
		this.soldItemInfoList=soldItemInfoList;
	}

	public SoldItemInfo addSoldItemInfoList(SoldItemInfo soldItemInfo)
	{
		soldItemInfoList.add(soldItemInfo);
		return soldItemInfo;
	}
	public SoldItemInfo reviseSoldItemInfoList(String soldItemCode, SoldItemInfo soldItemInfo)
	{
		int i=0;
		for (SoldItemInfo temp : soldItemInfoList)
		{
			if(soldItemCode.equals(temp.getSoldItemCode()))
			{
				((LinkedList<SoldItemInfo>)soldItemInfoList).set(i, soldItemInfo);
				return soldItemInfo;
			}
			i++;
		}
		return null;
	}
	public SoldItemInfo removeSoldItemInfoList(String soldItemCode)
	{
		SoldItemInfo temp=searchSoldItemInfoList(soldItemCode);
		if(temp==null)
			return null;
		soldItemInfoList.remove(temp);
		return temp;
	}
	public SoldItemInfo searchSoldItemInfoList(String soldItemCode)
	{
		for (SoldItemInfo temp : soldItemInfoList)
		{
			if(soldItemCode.equals(temp.getSoldItemCode()))
			{
				return temp;
			}
		}
		return null;
	}
}
