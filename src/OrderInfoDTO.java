
//  @ Project : Untitled
//  @ File Name : OrderInfoDTO.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//




public class OrderInfoDTO {
	private int orderInfoCode;
	private String orderDate;
	private String id;
	public OrderInfoDTO() {
		this(0,"","");
	}
	
	public OrderInfoDTO(int orderInfoCode, String orderDate, String id) {
		this.orderInfoCode = orderInfoCode;
		this.orderDate = orderDate;
		this.id = id;
	}
	
	public int getOrderInfoCode() {
		return orderInfoCode;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public String getId() {
		return id;
	}
	
	public void setOrderInfoCode(int orderInfoCode) {
		this.orderInfoCode = orderInfoCode;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "orderInfoCode : "+orderInfoCode+"orderDate : "+orderDate+"id : "+id;
	}
}
