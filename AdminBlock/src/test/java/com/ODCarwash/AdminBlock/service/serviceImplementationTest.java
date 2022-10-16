package com.ODCarwash.AdminBlock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ODCarwash.AdminBlock.model.Admin;
import com.ODCarwash.AdminBlock.model.CustomerRating;
import com.ODCarwash.AdminBlock.model.WashPack;
import com.ODCarwash.AdminBlock.repository.RatingRepository;
import com.ODCarwash.AdminBlock.repository.WashRepository;
import com.ODCarwash.AdminBlock.repository.adminRepo;

class serviceImplementationTest {

	@Test
	void testFindAll() {
		List<Admin> myUser = new ArrayList<Admin>();
		myUser.add(new Admin(1, "messi", "Goat", "goat"));
		myUser.add(new Admin(2, "Neymar", "Goatie", "Goatie"));
		
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Arepo.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, service.findAll().size());
	}

	@Test
	void testSaveadmin() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		Admin admin = new Admin(1, "messi", "Goat", "goat");
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Arepo.save(admin)).thenReturn(admin);     //mocking
		assertEquals("Added" , service.saveadmin(admin));
	}

	@Test
	void testUpdateadmin() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		Admin admin = new Admin(1, "messi", "Goat", "goat");
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Arepo.save(admin)).thenReturn(admin);     //mocking
		assertEquals("Updated" , service.updateadmin(admin));	}

	@Test
	void testDeleteadmin() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);

		Admin admin = new Admin(1, "messi", "Goat", "goat");
		assertEquals("Deleted", service.deleteadmin(1));	}

	@Test
	void testGetuser() {
		List<CustomerRating> myUser = new ArrayList<CustomerRating>();
		myUser.add(new CustomerRating("messi", 5, "very good"));
		myUser.add(new CustomerRating("Ronaldo", 3, "good"));
		
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Rrepo.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, service.getuser().size());
	}

	@Test
	void testSave() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		CustomerRating rating = new CustomerRating("messi", 5, "very good");
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Rrepo.save(rating)).thenReturn(rating);     //mocking
		assertEquals("Added" , service.save(rating));	
	}

	@Test
	void testGetwashpack() {
		List<WashPack> myUser = new ArrayList<WashPack>();
		myUser.add(new WashPack(1, "Basic", "very good", "500"));
		myUser.add(new WashPack(2, "v Basic", "good", "400"));
				
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Wrepo.findAll()).thenReturn(myUser);     //mocking
		
		assertEquals(2, service.getwashpack().size());
	}

	@Test
	void testSavepack() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		WashPack waspPack = new WashPack(1, "Basic", "very good", "500");
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Wrepo.save(waspPack)).thenReturn(waspPack);     //mocking
		assertEquals("Added" , service.savepack(waspPack));	
	}

	@Test
	void testUpdatepack() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		WashPack waspPack = new WashPack(1, "Basic", "very good", "500");
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);
		
		when(Wrepo.save(waspPack)).thenReturn(waspPack);     //mocking
		assertEquals("Updated" , service.updatepack(waspPack));
	}

	@Test
	void testDeletepack() {
		adminRepo Arepo = mock(adminRepo.class);
		RatingRepository Rrepo = mock(RatingRepository.class);
		WashRepository Wrepo = mock(WashRepository.class);
		
		serviceImplementation service = new serviceImplementation(Arepo, Rrepo, Wrepo);

		WashPack waspPack = new WashPack(1, "Basic", "very good", "500");
		assertEquals("Deleted", service.deletepack(1));
	}

}
