package io.start.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.start.product.Product;
import io.start.product.ProductRepo;

@Service
@Transactional
public class CustomService
{
	@Autowired
	private CustomRepo customRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	
	public List<Customer> findAll()
	{
		return (List<Customer>) customRepo.findAll();
	}
	
	
	public Customer findById(int id)
	{
		if(customRepo.existsById(id))
			return customRepo.findById(id).get();
		else
			return null;
	}
	
	
	
	public List<Product> findProduct(int id)
	{
		if(customRepo.existsById(id) == false)
			return null;
		else
			return productRepo.findAllByOwnerid(id);
	}
	
	
	
	public String save(Customer customer)
	{
		if(customRepo.existsById(customer.getId()))
			return "There is a customer given id: " + customer.getId();
		else
		{
			customRepo.save(customer);
			return customer.toString() + " is saved!!";
		}
		
	}
	
	public String delete(int id)
	{
		if(customRepo.existsById(id))
		{
			Customer deleting = customRepo.findById(id).get();
			
			productRepo.deleteAllByOwnerid(id);
			customRepo.deleteById(id);
			return deleting.toString() + " is deleted!!";
		}
		
		else
			return "No such customer having id: " + id;
	}
	
	
	
	
	

	public String updte(int id, Customer customer) {
		if(customRepo.existsById(id))
		{
			if(id != customer.getId())
				return "Id is not matched. Not Updated!!!";
			
			else
			{
				Customer old = customRepo.findById(id).get();
				customRepo.save(customer);
				return old.toString() + " is updated to " + customer.toString(); 
			}
			
		}
		else 
		   return "Do Not Updated. No such user given id " + id;
	}

}
