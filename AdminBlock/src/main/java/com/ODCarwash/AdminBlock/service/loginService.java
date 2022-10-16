package com.ODCarwash.AdminBlock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.model.login;
import com.ODCarwash.AdminBlock.repository.adminRepo;



@Service
public class loginService {
	@Autowired
	private adminRepo userRepo;

	public String userLogin(login Login) {
		ArrayList<Admin> list = (ArrayList<Admin>) userRepo.findAll();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getUsername().equals(Login.getUsername())
					&& list.get(i).getPassword().equals(Login.getPassword())) {

				count++;
			}
		}

		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}

	}

}

