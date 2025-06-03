package com.demo.cicd.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomerController {

	@GetMapping("/welcome")
	public String getWelcomeMessage(){
		
		return "Welcome RK";
	}
}
