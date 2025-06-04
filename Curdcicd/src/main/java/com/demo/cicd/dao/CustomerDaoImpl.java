package com.demo.cicd.dao;

import java.util.List;
import java.util.Optional;

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

	private final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> new Customer(rs.getInt("id"),
			rs.getString("name"), rs.getInt("age"), rs.getString("email"));

	@Override
	public Customer addCustomerDetails(Customer customer) {
		String sql ="insert into customer(age,email,name) values("+customer.getAge()+",'"+customer.getEmail()+"','"+customer.getName()+"')";
		jdbcTemplate.execute(sql);
		//jdbcTemplate.update(sql,customer.getId() ,customer.getAge(),customer.getEmail(),customer.getName());
		return customer;
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		String sql = "update customer set age=?,email=?,name=? where id=?";
		jdbcTemplate.update(sql, customer.getAge(), customer.getEmail(), customer.getName(), customer.getId());
		return customer;
	}

	@Override
	public void deleteCustomerDetails(int customerid) {
		String sql = "delete from customer where id=?";
		jdbcTemplate.update(sql,customerid);
	}

	@Override
	public List<Customer> findAll() {
		String sql = "select * from customer";
		return jdbcTemplate.query(sql, customerRowMapper);
	}

	@Override
	public Optional<Customer> findById(int id) {
		String sql = "select * from customer where id=?";
		return jdbcTemplate.query(sql, customerRowMapper, id).stream().findFirst();
	}

}
