package com.demo.cicd.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cicd.pojo.Customer;
import com.demo.cicd.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/welcome")
	public String getWelcomeMessage() {

		return "Welcome RK";
	}

	@GetMapping("/getAllCustomersDetails")
	public ResponseEntity<List<Customer>> getAllCustomerDetails(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
}
