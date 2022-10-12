package com.ODCarwash.AdminBlock.service;

import java.util.List;
import java.util.Optional;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.model.CustomerRating;
import com.ODCarwash.AdminBlock.model.WashPack;



public interface adminService {
	
	public List<Admin> findAll();
	public String saveadmin(Admin admin);
	public String updateadmin(Admin admin);
	public String deleteadmin(int id);
	public Optional<Admin> findAdminById(int id);
	
	
	public List<CustomerRating> getuser();
	public String save(CustomerRating ratings);
	
	
	public List<WashPack> getwashpack();
	public String savepack(WashPack Washpacks);
	public String updatepack(WashPack updatepack);
	public String deletepack(int id);
}
