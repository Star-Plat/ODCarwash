package com.ODCarwash.CustomerBlock.service;

import java.util.List;

import com.ODCarwash.CustomerBlock.model.signup;


public interface customerService {

		
		  public signup addUser(signup Signup);
		  public List<signup> getuser();
	      public String Updateuser(signup update);
		  public String deleteUserById(int id);
		  public Long getSequenceNumber(String sequenceName);
		  public signup deleteUser(signup user);
		
}