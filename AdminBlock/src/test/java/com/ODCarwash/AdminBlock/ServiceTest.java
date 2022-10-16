package com.ODCarwash.AdminBlock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.repository.adminRepo;
import com.ODCarwash.AdminBlock.service.serviceImplementation;

@SpringBootTest
public class ServiceTest {

	
	@Mock
	adminRepo Arepo;
	
	@InjectMocks
	serviceImplementation implementation;
	
	public List<Admin> myAdmin;
	
	@Test
	@Order(1)
	public void testFindAll() {
		List<Admin> myAdmin = new ArrayList<Admin>();
		myAdmin.add(new Admin(1, "messi", "Goat", "Goat"));
		myAdmin.add(new Admin(2, "ronaldo", "cr7", "CR7"));
		
		when(Arepo.findAll()).thenReturn(myAdmin);     //mocking
		
		assertEquals(2, implementation.findAll().size());
	}
}
