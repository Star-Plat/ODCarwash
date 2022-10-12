package com.ODCarwash.CustomerBlock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ODCarwash.CustomerBlock.model.signup;
import com.ODCarwash.CustomerBlock.repository.userRepository;
import com.ODCarwash.CustomerBlock.service.customerServiceImplementation;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class ServiceTest {

	
	@Mock
	userRepository repository;
	
	@InjectMocks
	customerServiceImplementation implementation;
	
	public List<signup> myUser;
	
	@Test
	@Order(1)
	public void testFindAll() {
		List<signup> myUser = new ArrayList<signup>();
		myUser.add(new signup((long) 1,"Messi", "Goat", "Ballon'dor", "Ballon'dor", "12234567890", "abcd@xyz.com"));
		myUser.add(new signup((long) 2, "Ronaldo", "cr7", "Ballon'dor", "Ballon'dor", "12234567890", "abcd@xyz.com"));
		
		when(repository.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, implementation.getuser().size());
	}
	
	@Test
	@Order(2)
	public void testAddUser() {
		signup signup = new signup((long) 3, "Neymar", "santos", "Brazil", "Brazil", "1234567890", "abcd@xyz.com");
		
		when(repository.save(signup)).thenReturn(signup);     //mocking
		assertEquals(signup, implementation.addUser(signup));
	}
	
	@Test
	@Order(2)
	public void testUpdateUser() {
		signup signup = new signup((long) 3, "Neymar", "santos", "Brazil", "Brazil", "1234567890", "abcd@xyz.com");
		
		when(repository.save(signup)).thenReturn(signup);     //mocking
		assertEquals("user updated", implementation.Updateuser(signup));
	}
	
	@Test
	@Order(4)
	public void testDeleteUserById() {
		signup signup = new signup((long) 3, "Neymar", "santos", "Brazil", "Brazil", "1234567890", "abcd@xyz.com");
		assertEquals("Deleted sucessfully", implementation.deleteUserById(3));
	}
	
	@Test
	@Order(5)
	public void testDeleteUser() {
		signup signup = new signup((long) 3, "Neymar", "santos", "Brazil", "Brazil", "1234567890", "abcd@xyz.com");
		assertEquals(signup, implementation.deleteUser(signup));

	}
	
}
