package com.pritam.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pritam.demo.model.Data;

@Repository
public interface DataDao extends CrudRepository<Data, Long> {

}
