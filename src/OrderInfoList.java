
//  @ Project : Untitled
//  @ File Name : OrderInfoList.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//



import java.util.*;
public class OrderInfoList {
	private Collection<OrderInfoDTO> orderInfoList;
	public OrderInfoList() {
		orderInfoList = new LinkedList<OrderInfoDTO>();
	}
	
	public OrderInfoList(Collection<OrderInfoDTO> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
	
	public OrderInfoDTO addOrderInfoList(OrderInfoDTO orderInfoDTO) {
		orderInfoList.add(orderInfoDTO);
		return orderInfoDTO;
	}
	
	public OrderInfoDTO removeOrderInfoList(OrderInfoDTO orderInfoDTO) {
		orderInfoList.remove(orderInfoDTO);
		return orderInfoDTO;
	}
	
	public OrderInfoDTO reviseOrderInfoList(OrderInfoDTO exOrderInfoDTO, OrderInfoDTO newOrderInfoDTO) {
		int index = ((LinkedList<OrderInfoDTO>)orderInfoList).indexOf(exOrderInfoDTO);
		if(index != -1){
			((LinkedList<OrderInfoDTO>)orderInfoList).set(index,newOrderInfoDTO);
			return newOrderInfoDTO;
		}
		return null;
	}
	
	public OrderInfoDTO searchOrderInfoList(OrderInfoDTO orderInfoDTO) {
		for(OrderInfoDTO dto : orderInfoList)
		{
			if(dto.getOrderInfoCode() == orderInfoDTO.getOrderInfoCode()){
				return dto;
			}
		}
		return null;
	}
	public Collection<OrderInfoDTO> getOrderInfoList()
	{
		return orderInfoList;
	}
	public void setOrderInfoList(Collection<OrderInfoDTO> orderInfoList)
	{
		this.orderInfoList=orderInfoList;
	}
}
