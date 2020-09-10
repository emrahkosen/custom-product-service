package io.start.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomRepo extends CrudRepository<Customer, Integer> 
{

}
