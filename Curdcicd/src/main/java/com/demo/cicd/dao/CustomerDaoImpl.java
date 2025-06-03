package com.demo.cicd.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.cicd.pojo.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private final JdbcTemplate jdbcTemplate;

	public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> new Customer(
			rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email")
	);

	@Override
	public Customer addCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomerDetails(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String sql = "select * from customer";
		return jdbcTemplate.query(sql, customerRowMapper);
	}

}
