package io.start.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> 
{
	public void deleteAllByOwnerid(int ownerid);
	public List<Product> findAllByOwnerid(int ownerid);

}
