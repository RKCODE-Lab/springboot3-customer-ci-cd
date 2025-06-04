package com.demo.cicd.service;

import java.util.List;
import java.util.Optional;

import com.demo.cicd.pojo.Customer;

public interface CustomerService {

	public Customer addCustomerDetails(Customer customer);

	public Customer updateCustomerDetails(Customer customer);

	public void deleteCustomerDetails(int id);

	public List<Customer> findAll();
	
	public Optional<Customer> findById(int id);
}
