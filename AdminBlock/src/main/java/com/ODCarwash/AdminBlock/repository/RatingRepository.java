package com.ODCarwash.AdminBlock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.AdminBlock.model.CustomerRating;

@Repository
public interface RatingRepository extends MongoRepository<CustomerRating, String> {
}
