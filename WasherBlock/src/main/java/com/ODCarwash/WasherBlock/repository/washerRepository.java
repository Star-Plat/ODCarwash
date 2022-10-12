package com.ODCarwash.WasherBlock.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.WasherBlock.model.washers;

@Repository
public interface washerRepository extends MongoRepository<washers, Integer> {

	List<washers> findBylocation(String location);
	
	washers findByName(String name);
}