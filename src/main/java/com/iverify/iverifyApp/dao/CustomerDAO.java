package com.iverify.iverifyApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iverify.iverifyApp.model.Customer;


@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {

	List<Customer> findAll();


	@SuppressWarnings("unchecked")
	Customer save(Customer customer);

	Customer findOne(long id);

	void delete(Customer findOne);


	Customer findByCustomerNameAndPassword(String customerName,
			String customerPassword);


	Customer findByCustomerName(String customerName);

	
	
	 
}