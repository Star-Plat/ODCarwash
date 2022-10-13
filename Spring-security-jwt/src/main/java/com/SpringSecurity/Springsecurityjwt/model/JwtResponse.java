package com.SpringSecurity.Springsecurityjwt.model;

public class JwtResponse {
	
	private final String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	
	

}
