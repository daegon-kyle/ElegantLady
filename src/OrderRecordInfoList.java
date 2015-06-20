//  @ File Name : �ֹ�������ϸ���Ʈ
//  @ Date : 2014-04-28
//  @ Author : ����
//
import java.util.*;
public class OrderRecordInfoList
{
	private Collection<OrderRecordInfo> orderRecordInfoList;
	
	public OrderRecordInfoList()
	{
		this(new LinkedList<OrderRecordInfo>());
	}
	public OrderRecordInfoList(Collection<OrderRecordInfo> orderRecordInfoList)
	{
		this.orderRecordInfoList=orderRecordInfoList;
	}
	
	public Collection<OrderRecordInfo> getOrderRecordInfoList()
	{
		return orderRecordInfoList;
	}
	public void setOrderRecordInfoList(Collection<OrderRecordInfo> orderRecordInfoList)
	{
		this.orderRecordInfoList=orderRecordInfoList;
	}

	public OrderRecordInfo addOrderRecordInfoList(OrderRecordInfo orderRecordInfo)
	{
		orderRecordInfoList.add(orderRecordInfo);
		return orderRecordInfo;
	}
	public OrderRecordInfo reviseOrderRecordInfoList(String orderCode, OrderRecordInfo orderRecordInfo)
	{
		int i=0;
		for (OrderRecordInfo temp : orderRecordInfoList)
		{
			if(orderCode.equals(temp.getOrderCode()))
			{
				((LinkedList<OrderRecordInfo>)orderRecordInfoList).set(i, orderRecordInfo);
				return orderRecordInfo;
			}
			i++;
		}
		return null;
	}
	public OrderRecordInfo removeOrderRecordInfoList(String orderCode)
	{
		OrderRecordInfo temp=searchOrderRecordInfo(orderCode);
		if(temp==null)
			return null;
		orderRecordInfoList.remove(temp);
		return temp;
	}
	public OrderRecordInfo searchOrderRecordInfo(String orderCode)
	{
		for (OrderRecordInfo temp : orderRecordInfoList)
		{
			if(orderCode.equals(temp.getOrderCode()))
			{
				return temp;
			}
		}
		return null;
	}
}
