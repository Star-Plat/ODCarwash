package com.ODCarwash.CustomerBlock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ODCarwash.CustomerBlock.model.bookingDetails;
import com.ODCarwash.CustomerBlock.model.customerRating;
import com.ODCarwash.CustomerBlock.model.login;
import com.ODCarwash.CustomerBlock.model.signup;
import com.ODCarwash.CustomerBlock.model.washpacks;
import com.ODCarwash.CustomerBlock.service.customerServiceImplementation;
import com.ODCarwash.CustomerBlock.service.loginService;

@RestController
@RequestMapping("/cust")
public class customerController {
	
	@Autowired
	private loginService user;
	
	@Autowired
	private customerServiceImplementation service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/adduser")
	public String saveUser(@RequestBody signup Signup) {
		Signup.setId(service.getSequenceNumber(signup.SEQUENCE_NAME));
		service.addUser(Signup);
		return "User added";
	}

	@GetMapping("/allusers")
	public List<signup> findAllUsers() {
		return service.getuser();
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody signup signup) {
		String result = service.Updateuser(signup);
		return result;
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteuser(@PathVariable int id) {
		return service.deleteUserById(id);
	}

	@PostMapping("/login")
	public String userLogin(@RequestBody login login) {
		return user.userLogin(login);
	}
	
	//--------------------------------------------------------------//
	
	@GetMapping("/allpacks")
	public List<washpacks> getwashpacks() {
		String baseurl = "http://localhost:8081/admin/allpacks";
		washpacks[] wp = restTemplate.getForObject(baseurl, washpacks[].class);
		return Arrays.asList(wp);
	}

	@PostMapping("/addorder")
	public String addorder(@RequestBody bookingDetails order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<bookingDetails> entity = new HttpEntity<bookingDetails>(order, headers);

		return restTemplate.exchange("http://localhost:8083/order/addorder", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@DeleteMapping("/cancelorder")
	public String deleteorder(@RequestParam int id) {
		String baseurl = "http://localhost:8083/order/cancelorder";
		bookingDetails order = restTemplate.getForObject(baseurl, bookingDetails.class);
		return "Your Order is successfully Canceled " + order;
	}

	@PostMapping("/addratings")
	public String addrating(@RequestBody customerRating rating) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<customerRating> entity = new HttpEntity<customerRating>(rating, headers);

		return restTemplate.exchange("http://localhost:8081/admin/addratings", HttpMethod.POST, entity, String.class)
				.getBody();
	}
}
