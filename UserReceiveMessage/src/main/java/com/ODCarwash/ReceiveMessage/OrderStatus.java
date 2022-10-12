package com.ODCarwash.ReceiveMessage;

public class OrderStatus {
	private Order order;
	private String Status;
	private String message;
	public OrderStatus(Order order, String status, String message) {
		super();
		this.order = order;
		Status = status;
		this.message = message;
	}
	public OrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrderStatus [order=" + order + ", Status=" + Status + ", message=" + message + "]";
	}
	
}
