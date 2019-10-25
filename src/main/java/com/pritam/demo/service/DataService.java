package com.pritam.demo.service;

import java.util.List;

import com.pritam.demo.model.Data;

public interface DataService {

    Data save(Data data);
    List<Data> findAll();
    Data find(long id);
    void delete(long id);
}
