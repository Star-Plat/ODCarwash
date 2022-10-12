package com.ODCarwash.ReceiveMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserReceiveMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserReceiveMessageApplication.class, args);
	}

}
