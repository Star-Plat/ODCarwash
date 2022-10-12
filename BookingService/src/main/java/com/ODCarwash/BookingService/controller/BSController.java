package com.ODCarwash.BookingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ODCarwash.BookingService.model.bookingDetails;
import com.ODCarwash.BookingService.repository.BSRepository;
import com.ODCarwash.BookingService.service.bookingServiceImpl;

@RestController
@RequestMapping("/order")
public class BSController {

	@Autowired
	private bookingServiceImpl BS;

	@Autowired
	private BSRepository repo;

	// Order Operations
	@PostMapping("/addorder")
	public String addorder(@RequestBody bookingDetails order) {
		order.setOrderId(BS.getSequenceNumber(bookingDetails.SEQUENCE_NAME));
		BS.addorder(order);
		return "order placed with washer" + order;
	}

	@GetMapping("/allorders")
	public List<bookingDetails> getorder() {
		return repo.findAll();
		}

	@PutMapping("/updateorder")
	public String updateDetails(@RequestBody bookingDetails order) {
		BS.updateorder(order);
		return "Updated sucessfully";
	}

	@DeleteMapping("/cancelorder/{id}")
	public ResponseEntity<Object> deletorder(@RequestParam int id) throws Exception {
		boolean isOrderExist = repo.existsById(id);
		if (isOrderExist) {
			BS.deleteById(id);
			return new ResponseEntity<Object>("Order deleted with id " + id, HttpStatus.OK);
		} else {
			throw new Exception("ORDER NOT FOUND WITH THIS ID:" + id);
		}
	}
}
