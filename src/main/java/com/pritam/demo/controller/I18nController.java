package com.pritam.demo.controller;

// https://www.baeldung.com/spring-boot-internationalization
// https://github.com/eugenp/tutorials/blob/master/spring-boot/src/main/resources/templates/international.html

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class I18nController {

	// http://localhost:8080/international?lang=fr
    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }

}