package com.ODCarwash.WasherBlock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODCarwash.WasherBlock.model.login;
import com.ODCarwash.WasherBlock.model.washers;
import com.ODCarwash.WasherBlock.repository.washerRepository;



@Service
public class loginService {
	@Autowired
	private washerRepository userRepo;

	public String userLogin( login Login) {
		ArrayList<washers> list = (ArrayList<washers>) userRepo.findAll();
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

