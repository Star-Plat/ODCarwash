package com.ODCarwash.PaymentBlock.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ODCarwash.PaymentBlock.model.databaseSequence;
import com.ODCarwash.PaymentBlock.model.paymentDetails;
import com.ODCarwash.PaymentBlock.repository.PBRepository;

@Service
public class PBServiceImpl{
	
	
	private PBRepository repo;
	
	@Autowired 
	private MongoOperations mongoOp;
	
	@Autowired
	public PBServiceImpl(PBRepository repo) {
		this.repo = repo;
	}

	public paymentDetails pay(paymentDetails payment) {
		payment.setPaymentstatus(paystatus());
		payment.setTransId(UUID.randomUUID().toString());
		return repo.save(payment);
	}
	
	private String paystatus() {
		return new Random().nextBoolean()?"success":"failure";
	}
  	  
	  public long getSequenceNumber(String sequenceName) { 
		  Query query = new Query(Criteria.where("id").is(sequenceName)); 
		  Update update = new Update().inc("seq", 1); 
			databaseSequence counter = mongoOp.findAndModify(query, update, options().returnNew(true).upsert(true),databaseSequence.class);
		  return !Objects.isNull(counter) ? counter.getSeq() : 1;
	  
	  
	  
	  }
	 

}
