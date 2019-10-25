package com.pritam.demo.actuate;

// https://www.journaldev.com/21597/spring-boot-actuator-endpoints
// https://www.baeldung.com/spring-boot-actuators

// http://localhost:8080/actuator/health
// http://localhost:8080/actuator/info
// http://localhost:8080/actuator/mappings
// http://localhost:8080/actuator/metrics
// http://localhost:8080/actuator/env
// http://localhost:8080/actuator/env/java.home
// http://localhost:8080/management/beans
// http://localhost:8080/actuator/threaddump
// http://localhost:8080/actuator/myendpoint

import java.util.ArrayList;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="myendpoint")
@Component
public class MyCustomEndpoints {

	@ReadOperation
	@Bean
	public ArrayList<String> hi() {
		ArrayList<String> messages = new ArrayList<String>();
        messages.add("This is message 1");
        messages.add("This is message 2");
        return messages;
	}
}