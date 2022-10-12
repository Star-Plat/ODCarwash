package com.ODCarwash.CustomerBlock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODCarwash.CustomerBlock.model.login;
import com.ODCarwash.CustomerBlock.model.signup;
import com.ODCarwash.CustomerBlock.repository.userRepository;



@Service
public class loginService {
	@Autowired
	private userRepository userRepo;

	public String userLogin(login Login) {
		ArrayList<signup> list = (ArrayList<signup>) userRepo.findAll();
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

