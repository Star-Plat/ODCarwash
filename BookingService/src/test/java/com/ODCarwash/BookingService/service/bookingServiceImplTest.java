package com.ODCarwash.BookingService.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ODCarwash.BookingService.model.bookingDetails;
import com.ODCarwash.BookingService.repository.BSRepository;

@SpringBootTest
class bookingServiceImplTest {

	@Mock
	BSRepository repository;
	
	@InjectMocks
	bookingServiceImpl implementation;
	
	@Test
	void testAddorder() {
		bookingDetails BDet = new bookingDetails((long) 1, "Honda", "Jazz", "Messi", "12thoct", null, "kolkata", 1);
		
		when(repository.save(BDet)).thenReturn(BDet);     //mocking
		assertEquals("booking done",implementation.addorder(BDet));
	}

	@Test
	void testOrderdetails() {
		List<bookingDetails> myUser = new ArrayList<bookingDetails>();
		myUser.add(new bookingDetails((long) 1, "Honda", "Jazz", "Messi", "12thoct", null, "kolkata", 1));
		myUser.add(new bookingDetails((long) 2, "Honda", "city", "Messi", "12thoct", null, "kolkata", 1));		
		when(repository.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, implementation.orderdetails().size());	}

	@Test
	void testUpdateorder() {
		bookingDetails BDet = new bookingDetails((long) 1, "Honda", "Jazz", "Messi", "12thoct", null, "kolkata", 1);
		
		when(repository.save(BDet)).thenReturn(BDet);     //mocking
		assertEquals("updated", implementation.updateorder(BDet));	}

	@Test
	void testDeleteById() {
		bookingDetails BDet = new bookingDetails((long) 1, "Honda", "Jazz", "Messi", "12thoct", null, "kolkata", 1);
		assertEquals("Deleted", implementation.deleteById(1));
	}

}
