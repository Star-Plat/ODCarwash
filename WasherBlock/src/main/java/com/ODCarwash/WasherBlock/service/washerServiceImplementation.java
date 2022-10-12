package com.ODCarwash.WasherBlock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODCarwash.WasherBlock.model.washers;
import com.ODCarwash.WasherBlock.repository.washerRepository;

@Service
public class washerServiceImplementation implements washerService {
	@Autowired
	private washerRepository repo;

	@Override
	public washers addWasher(washers washer) {
		// TODO Auto-generated method stub
		return repo.save(washer);
	}

	@Override
	public List<washers> getwashers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<washers> getwasherbylocation(String location) {
		// TODO Auto-generated method stub
		List<washers> newWash = repo.findBylocation(location);
		return newWash;
	}

	@Override
	public String deletewasher(washers washer) {
		// TODO Auto-generated method stub
		repo.delete(washer);
		return "Deleted";
	}

	
	
	
	
	

}
