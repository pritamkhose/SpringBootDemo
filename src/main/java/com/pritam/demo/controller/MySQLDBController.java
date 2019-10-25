package com.pritam.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pritam.demo.model.Data;
import com.pritam.demo.service.DataService;

@RestController
@RequestMapping("/data")
@Api(description = "MySQL Database CRUD operation")
public class MySQLDBController {
	

    @Autowired
    private DataService dataService;
    
    @ApiOperation(value = "View a list")
    @RequestMapping(value="/data", method = RequestMethod.GET)
    public List<Data> listData(){
        return dataService.findAll();
    }
 

    @RequestMapping(value="/data/{id}", method = RequestMethod.GET)
    public Data getData(@PathVariable(value = "id") Long id){
        return dataService.find(id);
    }
    
    

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public Data create(@RequestBody Data data){
        return dataService.save(data);
    }

    @RequestMapping(value = "/data/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        dataService.delete(id);
        return "success";
    }

}
