package dao;

import model.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CustomerDAO extends CrudRepository<Customer, Long> {

	List<Customer> findAll();


	@SuppressWarnings("unchecked")
	Customer save(Customer customer);

	Customer findOne(long id);

	void delete(Customer findOne);

	
	
	 
}