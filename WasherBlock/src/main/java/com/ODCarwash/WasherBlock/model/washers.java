package com.ODCarwash.WasherBlock.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Washerdb")
public class washers {
	
	@Id
	private int id;
	private String name;
	private String location;
	private String password;
	private String username;
	public washers(int id, String name, String location, String password, String username) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.password = password;
		this.username = username;
	}
	public washers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "washers [id=" + id + ", name=" + name + ", location=" + location + ", password=" + password
				+ ", username=" + username + "]";
	}
}
