package com.pritam.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.demo.model.Pets;
import com.pritam.demo.service.MongoDBRepository;

import javax.validation.Valid;
import java.util.List;

//https://www.journaldev.com/18156/spring-boot-mongodb
//https://www.codementor.io/gtommee97/rest-api-java-spring-boot-and-mongodb-j7nluip8d
//https://www.baeldung.com/queries-in-spring-data-mongodb

@RestController
@RequestMapping("/mongodbcurd")
public class MongoDBController {
	@Autowired
	private MongoDBRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pets> getAllPets() {
		return repository.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH)
	public List<Pets> getFindPets(@RequestParam("serach") String serach) {
		if (serach != null && serach.length() > 1) {
			return null; // repository.findbySerach(serach);
		} else {
			return repository.findAll();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pets getPetById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Pets pets) {
		pets.set_id(id);
		repository.save(pets);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Valid @RequestBody Pets pets) {
		repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable String id) {
		// Pets pet = repository.findOne(id);
		// repository.delete(pet);
	}

}
