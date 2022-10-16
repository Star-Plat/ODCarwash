package com.ODCarwash.AdminBlock.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.model.BookingDetails;
import com.ODCarwash.AdminBlock.model.CustomerRating;
import com.ODCarwash.AdminBlock.model.WashPack;
import com.ODCarwash.AdminBlock.model.Washers;
import com.ODCarwash.AdminBlock.model.login;
import com.ODCarwash.AdminBlock.service.loginService;
import com.ODCarwash.AdminBlock.service.serviceImplementation;


@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private loginService user;
	
	@Autowired
	private serviceImplementation service;
	
	@Autowired
	private RestTemplate restTemplate;

    @PostMapping("/addadmin")
    public String saveAdmin(@RequestBody Admin admin){
        service.saveadmin(admin);
        return "Added admin with id: " + admin.getId();
    }
    
    @GetMapping("/alladmin")
	public List<Admin> getadmin() {
		return service.findAll();
	}
    
    @GetMapping("/alladmin/{id}")
   	public Optional<Admin> getAdminById(@PathVariable int id) {
   		return service.findAdminById(id);
   	}
    
    @PutMapping("/updateadmin")
	public String updateadmin(@RequestBody Admin admin) {
    	service.updateadmin(admin);
    	return "Admin updated successfully with Id:" + admin.getId();
	}
    
    @DeleteMapping("/deleteadmin/{id}")
	public String deleteadmin(@PathVariable int id) {
    	service.deleteadmin(id);
    	return "Sucessfully deleted admin";
	}
    
    @PostMapping("/login")
	public String userLogin(@RequestBody login login) {
		return user.userLogin(login);
	}
    //-------------------------------------------------------//
    
    @GetMapping("/allpacks")
	public List<WashPack> getwashpacks() {
		return service.getwashpack();
	}

	@PostMapping("/addpack")
	public String savepack(@RequestBody WashPack wp) {
		service.savepack(wp);
		return "New pack added";
	}
	
	@PutMapping("/updatepack")
	public String savepacku(@RequestBody WashPack wp) {
		service.updatepack(wp);
		return "New pack added";
	}
	
	@DeleteMapping("/deletepack/{id}")
	public String deletepack(@RequestParam int id) {
		service.deletepack(id);
		return "pack deleted";
	}
	
//----------------------------------------------------------------------------------//
	
	@PostMapping("/addratings")
	public String saveratings(@RequestBody CustomerRating rating) {
		service.save(rating);
		return "Thanks for your feedback";
	}

	@GetMapping("/allratings")
	public List<CustomerRating> getuser() {
		return service.getuser();
	}

//-------------------------------------------------//
	//Booking
	@GetMapping("/allorders")
	public List<BookingDetails> getorder() {
		String baseurl = "http://localhost:8083/order/allorders";
		BookingDetails[] allorders = restTemplate.getForObject(baseurl, BookingDetails[].class);
		return Arrays.asList(allorders);
	}

	//Washer
	@GetMapping("/allwashers")
	public List<Washers> findAllwashers() {
		String baseurl = "http://localhost:8082/wash/allwashers";
		Washers[] wash = restTemplate.getForObject(baseurl, Washers[].class);
		return Arrays.asList(wash);
	}
}
