package com.demo.cicd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cicd.pojo.Customer;
import com.demo.cicd.service.CustomerService;
import com.demo.cicd.service.CustomerServiceImpl;
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

	@GetMapping("/ok")
	public String getWelcomeMessage() {
		return "Welcome RK";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Customer> getCustomerDetailsById(@PathVariable("id") Integer id) {
		return customerService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping("/addNewCustomer")
	public ResponseEntity<Customer> addNewCustomerDetails(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.addCustomerDetails(customer));
	}
	
	@PutMapping("/updateCustomerDetails/{id}")
	public ResponseEntity<Customer> updateCustomerDetails(@PathVariable("id") Integer id,@RequestBody Customer updateCustomer){
		if(!customerService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(customerService.updateCustomerDetails(updateCustomer));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteCustomerDetailsById(@PathVariable("id") Integer id){
		if(!customerService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		customerService.deleteCustomerDetails(id);
		return ResponseEntity.ok().build();
	}
}
