package com.ODCarwash.AdminBlock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.AdminBlock.model.Admin;

@Repository
public interface adminRepo extends MongoRepository<Admin, Integer> {
}
