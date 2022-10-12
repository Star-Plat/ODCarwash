package com.ODCarwash.PaymentBlock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ODCarwash.PaymentBlock.model.paymentDetails;
import com.ODCarwash.PaymentBlock.service.PBServiceImpl;

@RestController
@RequestMapping("/payment")
public class PBController {
	
	@Autowired
	public PBServiceImpl service;
	
	@PostMapping("/pay")
	public paymentDetails pay(@RequestBody paymentDetails payment) {
	 //payment.setTransId(service.getSequenceNumber(paymentDetails.SEQUENCE_NAME));
		return service.pay(payment);
	}

}

