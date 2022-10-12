package com.ODCarwash.AdminBlock.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washpackdb")
public class WashPack {
    @Id
    private int id;
    private String packname;
    private String description;
    private String cost;
    
    
    public WashPack(int id, String packname, String description, String cost) {
		super();
		this.id = id;
		this.packname = packname;
		this.description = description;
		this.cost = cost;
	}
	public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPackname() {
        return packname;
    }
    public void setPackname(String packname) {
        this.packname = packname;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "washpack [id=" + id + ", packname=" + packname + ",cost="+ cost +", description=" + description + "]";
    }
}
