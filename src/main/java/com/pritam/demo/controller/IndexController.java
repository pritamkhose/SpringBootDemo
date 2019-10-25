package com.pritam.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public Object getData(){
    	HashMap<String, Object> hm = new HashMap();
    	hm.put("Message", "Server is Running");
    	hm.put("Date", new Date());
        return hm;
    }
    
}
