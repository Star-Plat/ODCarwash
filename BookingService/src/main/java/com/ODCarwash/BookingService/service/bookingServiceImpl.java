package com.ODCarwash.BookingService.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ODCarwash.BookingService.model.bookingDetails;
import com.ODCarwash.BookingService.model.databaseSequence;
import com.ODCarwash.BookingService.repository.BSRepository;

@Service
public class bookingServiceImpl implements bookingService {

	@Autowired
	private BSRepository repo;
	
	@Autowired
	private MongoOperations mongoOP;
	
	@Override
	public String addorder(bookingDetails booking) {
		// TODO Auto-generated method stub
		repo.save(booking);
		return "booking done";
	}

	@Override
	public List<bookingDetails> orderdetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String updateorder(bookingDetails update) {
		// TODO Auto-generated method stub
		repo.save(update);
		return "updated";
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Deleted";
	}

	@Override
	public Long getSequenceNumber(String sequenceName) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seq", 1);
		databaseSequence counter = mongoOP.findAndModify(query, update, options().returnNew(true).upsert(true),databaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
