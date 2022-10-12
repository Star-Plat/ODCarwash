package com.ODCarwash.WasherBlock.service;

import java.util.List;

import com.ODCarwash.WasherBlock.model.washers;

public interface washerService {

	public washers addWasher(washers washer);

	public List<washers> getwashers();

	public List<washers> getwasherbylocation(String location);

	public String deletewasher(washers washer);

}
