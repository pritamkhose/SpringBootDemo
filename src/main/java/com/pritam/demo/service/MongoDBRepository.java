package com.pritam.demo.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pritam.demo.model.Pets;

// @Repository
public interface MongoDBRepository extends MongoRepository<Pets, String>  {
  
	Pets findBy_id(ObjectId id);

	//Pets findOne(String id);

	//List<Pets> findbySerach(String serach);

}
