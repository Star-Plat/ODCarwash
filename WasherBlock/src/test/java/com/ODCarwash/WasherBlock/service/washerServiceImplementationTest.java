package com.ODCarwash.WasherBlock.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ODCarwash.WasherBlock.model.washers;
import com.ODCarwash.WasherBlock.repository.washerRepository;

@SpringBootTest
class washerServiceImplementationTest{

	@Mock
	washerRepository repository;
	
	@InjectMocks
	washerServiceImplementation implementation;
	
	@Test
	void testAddWasher() {
		washers wash = new washers(1, "messi", "Kolkata","Goat", "Goat");
		
		when(repository.save(wash)).thenReturn(wash);     //mocking
		assertEquals(wash,implementation.addWasher(wash));
	}

	@Test
	void testGetWashers() {
		List<washers> myUser = new ArrayList<washers>();
		myUser.add(new washers(1, "messi", "Kolkata","Goat", "Goat"));
		myUser.add(new washers(2, "Ronaldo", "Goa","CR7", "Goat"));		
		
		when(repository.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, implementation.getwashers().size());	}

	@Test
	void testGetWasherByLocation() {
		washers wash = new washers(1, "messi", "Kolkata","Goat", "goat");
		
		when(repository.save(wash)).thenReturn(wash);     //mocking
		assertEquals(0, implementation.getwasherbylocation("Kolkata").size());	
	}

	@Test
	void testDeleteWasher() {
		washers wash = new washers(1, "messi", "Kolkata","Goat", "goat");
		assertEquals("Deleted", implementation.deletewasher(wash));
	}

}
