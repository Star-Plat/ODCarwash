package com.SpringSecurity.Springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.Springsecurityjwt.Utility.JWTUtility;
import com.SpringSecurity.Springsecurityjwt.model.JwtRequest;
import com.SpringSecurity.Springsecurityjwt.model.JwtResponse;
import com.SpringSecurity.Springsecurityjwt.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String home() {
		return "Hello Home";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtreq) throws Exception {
		try {
			authenticationManager.authenticate(
					new  UsernamePasswordAuthenticationToken(jwtreq.getUsername(),jwtreq.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid_credentials",e);
		}
		
		final UserDetails userDetails=userservice
				.loadUserByUsername(jwtreq.getUsername());
		
		final String Token=jwtUtility.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(Token));
	}
}
