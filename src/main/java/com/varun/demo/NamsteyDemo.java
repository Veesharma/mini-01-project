package com.varun.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NamsteyDemo {
	
	@GetMapping("/demo")
	public String newRestController() {
		return "Namstey in Bharat Spring Boot" ;
	}

}
