package com.ODCarwash.CustomerBlock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ODCarwash.CustomerBlock.model.signup;

public interface userRepository extends MongoRepository<signup, Integer> {

}
