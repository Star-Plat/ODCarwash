package com.ODCarwash.BookingService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.BookingService.model.bookingDetails;

@Repository
public interface BSRepository extends MongoRepository<bookingDetails, Integer> {
	
	boolean save(int id);

}
