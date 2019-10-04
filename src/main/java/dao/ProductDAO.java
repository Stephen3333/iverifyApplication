package dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import model.Product;

@Transactional
public interface ProductDAO extends CrudRepository<Product, Long> {

	Product findOne(long id);

	List<Product> findAll();

	
	@SuppressWarnings("unchecked")
	Product save(Product product);

	void delete(Product findOne);
    
}
