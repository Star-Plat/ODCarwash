package com.ODCarwash.PaymentBlock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.PaymentBlock.model.paymentDetails;

@Repository
public interface PBRepository extends MongoRepository<paymentDetails, Integer> {

}
