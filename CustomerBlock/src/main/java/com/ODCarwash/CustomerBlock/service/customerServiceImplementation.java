package com.ODCarwash.CustomerBlock.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ODCarwash.CustomerBlock.model.databaseSequence;
import com.ODCarwash.CustomerBlock.model.signup;
import com.ODCarwash.CustomerBlock.repository.userRepository;

@Service
public class customerServiceImplementation implements customerService{

	
	@Autowired
	private userRepository repo;
	
	
	
	@Override
	public signup addUser(signup signup) {
		return repo.save(signup);
	}

	@Override
	public List<signup> getuser() {
		List<signup> users=repo.findAll();
		return users;
	}

	@Override
	public String Updateuser(signup update) {
		   repo.save(update);
		    return "user updated";
	}

	@Override
	public String deleteUserById(int id) {
		 repo.deleteById(id);
		 return "Deleted sucessfully";
	}

	
	
	  @Autowired
	  private MongoOperations mongoOperations;



	  public Long getSequenceNumber(String sequenceName) {
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  Update update = new Update().inc("seq", 1);
	  databaseSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), databaseSequence.class);



	  return !Objects.isNull(counter) ? counter.getSeq() : 1;



	  }

	@Override
	public signup deleteUser(signup user) {
		// TODO Auto-generated method stub
		repo.delete(user);
		 return user; 
	}
	
}
	
