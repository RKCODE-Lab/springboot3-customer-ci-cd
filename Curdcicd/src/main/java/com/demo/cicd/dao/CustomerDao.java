package com.demo.cicd.dao;

import java.util.List;
import java.util.Optional;

import com.demo.cicd.pojo.Customer;

public interface CustomerDao {

	public Customer addCustomerDetails(Customer customer);

	public Customer updateCustomerDetails(Customer customer);

	public void deleteCustomerDetails(int id);

	public List<Customer> findAll();
	
	public Optional<Customer> findById(int id);
}
