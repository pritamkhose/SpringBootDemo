package com.pritam.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.demo.model.Pets;
import com.pritam.demo.service.MongoDBRepository;


@RestController
@RequestMapping("/mongodbcurd")
public class MongoDBController {
	@Autowired
	private MongoDBRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Pets>> getAllPets() {
		List<Pets> p = repository.findAll();
		return new ResponseEntity<List<Pets>>(p, p.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH)
	public ResponseEntity<List<Pets>> getFindPets(@RequestParam("serach") String serach) {
		if (serach != null && serach.length() > 1) {
			List<Pets> p = repository.findAll(); // repository.findbySerach(serach);
			return new ResponseEntity<List<Pets>>(p, p.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Pets>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pets> getPetById(@PathVariable("id") ObjectId id) {
		Pets p = repository.findBy_id(id);
		return new ResponseEntity<Pets>(p, p == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Pets modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Pets pets) {
		pets._id =id;
		repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Valid @RequestBody Pets pets) {
		repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePet(@PathVariable ObjectId id) {
		Pets p = repository.findBy_id(id);
		repository.deleteById(id.toString());
		return new ResponseEntity<>(p == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

}
