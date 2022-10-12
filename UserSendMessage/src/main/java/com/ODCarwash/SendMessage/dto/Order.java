package com.ODCarwash.SendMessage.dto;

public class Order {

	private String name;
	private String status;
	private double price;
	private String id;
	public Order(String name, String status, double price, String id) {
		super();
		this.name = name;
		this.status = status;
		this.price = price;
		this.id = id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", status=" + status + ", price=" + price + ", id=" + id + "]";
	}
	
	
}
