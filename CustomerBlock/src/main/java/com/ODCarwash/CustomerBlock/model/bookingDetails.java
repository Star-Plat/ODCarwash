package com.ODCarwash.CustomerBlock.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Bookingdetailsdb")
public class bookingDetails {
		
	
	@Id
	private int id;
	
	private String CarName;

	private String Model;

	private String washerName;
	
	private int washpackId;
	
	private String Date;

	private long contact;
	
	public bookingDetails(int id, String carName, String model, String washerName, int washpackId, String date,
			long contact) {
		super();
		this.id = id;
		CarName = carName;
		Model = model;
		this.washerName = washerName;
		this.washpackId = washpackId;
		Date = date;
		this.contact = contact;
	}
	public bookingDetails() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public int getWashpackId() {
		return washpackId;
	}
	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Bookingdetails [id=" + id + ", CarName=" + CarName + ", Model=" + Model + ", washerName=" + washerName
				+ ", washpackId=" + washpackId + ", Date=" + Date + ", contact=" + contact + "]";
	}
}
