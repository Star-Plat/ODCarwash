package com.ODCarwash.AdminBlock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ODCarwash.AdminBlock.model.WashPack;

@Repository
public interface WashRepository extends MongoRepository<WashPack, Integer> {
}
