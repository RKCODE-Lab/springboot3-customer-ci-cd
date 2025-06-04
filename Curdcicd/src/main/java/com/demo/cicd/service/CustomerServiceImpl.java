package com.demo.cicd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.cicd.dao.CustomerDao;
import com.demo.cicd.pojo.Customer;

@Service(value = "customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Transactional
	@Override
	public Customer addCustomerDetails(Customer customer) {
		return customerDao.addCustomerDetails(customer);
	}

	@Transactional
	@Override
	public Customer updateCustomerDetails(Customer customer) {
		return customerDao.updateCustomerDetails(customer);
	}

	@Transactional
	@Override
	public void deleteCustomerDetails(int customerid) {
		customerDao.deleteCustomerDetails(customerid);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Optional<Customer> findById(int id) {
		return customerDao.findById(id);
	}



}
