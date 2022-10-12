package com.ODCarwash.ReceiveMessage;

public class Order {

	private String Id;
	private String name;
	private double price;
	private String status;
	public Order(String id, String name, double price, String status) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [Id=" + Id + ", name=" + name + ", price=" + price + ", status=" + status + "]";
	}

}