package com.ODCarwash.PaymentGateway;

public class PaypalOrder {
	
	private double price;
	private String currency;
	private String method;
	private String intent;
	private String desc;
	public PaypalOrder(double price, String currency, String method, String intent, String desc) {
		super();
		this.price = price;
		this.currency = currency;
		this.method = method;
		this.intent = intent;
		this.desc = desc;
	}
	public PaypalOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "PaypalOrder [price=" + price + ", currency=" + currency + ", method=" + method + ", intent=" + intent
				+ ", desc=" + desc + "]";
	}
	
	
}
