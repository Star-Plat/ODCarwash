package com.ODCarwash.AdminBlock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.model.CustomerRating;
import com.ODCarwash.AdminBlock.model.WashPack;
import com.ODCarwash.AdminBlock.repository.RatingRepository;
import com.ODCarwash.AdminBlock.repository.WashRepository;
import com.ODCarwash.AdminBlock.repository.adminRepo;


@Service
public class serviceImplementation implements adminService {
	
	private adminRepo AR;
	private WashRepository WR;
	private RatingRepository RR;
	
	@Autowired
	public serviceImplementation(adminRepo aR, RatingRepository rR, WashRepository wR) {
		AR= aR;
		RR= rR;
		WR = wR;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return AR.findAll();
		}

	@Override
	public String saveadmin(Admin admin) {
		// TODO Auto-generated method stub
		AR.save(admin);
		return "Added";
		}

	@Override
	public String updateadmin(Admin admin) {
		// TODO Auto-generated method stub
		AR.save(admin);
		return "Updated";
		}

	@Override
	public String deleteadmin(int id) {
		// TODO Auto-generated method stub
		AR.deleteById(id);
		return "Deleted";
		}

	@Override
	public List<CustomerRating> getuser() {
		// TODO Auto-generated method stub
		return RR.findAll();
	}

	@Override
	public String save(CustomerRating ratings) {
		// TODO Auto-generated method stub
		RR.save(ratings);	
		return "Added";
	}

	@Override
	public List<WashPack> getwashpack() {
		// TODO Auto-generated method stub
		return WR.findAll();
	}

	@Override
	public String savepack(WashPack Washpacks) {
		// TODO Auto-generated method stub
		WR.save(Washpacks);
		return "Added";
	}

	@Override
	public String updatepack(WashPack updatepack) {
		// TODO Auto-generated method stub
		WR.save(updatepack);
		return "Updated";
	}

	@Override
	public String deletepack(int id) {
		// TODO Auto-generated method stub
		WR.deleteById(id);
		return "Deleted";
	}

	@Override
	public Optional<Admin> findAdminById(int id) {
		// TODO Auto-generated method stub
		return AR.findById(id);
	}

}

