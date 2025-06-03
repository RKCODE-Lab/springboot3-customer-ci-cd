package com.demo.cicd.dao;

import java.util.List;

import com.demo.cicd.pojo.Customer;

public interface CustomerDao {

	public Customer addCustomerDetails(Customer customer);

	public Customer updateCustomerDetails(Customer customer);

	public Customer deleteCustomerDetails(int customerid);

	public List<Customer> getAllCustomers();
}
