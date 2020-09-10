package io.start.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.start.customer.CustomRepo;

@Service
public class ProductService 
{
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CustomRepo customRepo;
	
	public List<Product> findAll()
	{
		return (List<Product>) productRepo.findAll();
	}
	public Product findById(int id)
	{
		if(productRepo.existsById(id))
			return productRepo.findById(id).get();
		else 
			return null;
	}
	
	
	public String save(Product product)
	{
		if(productRepo.existsById(product.getId()))
		{
			return "There is a product given id!!";
		}
		
		else if(!customRepo.existsById(product.getOwnerId()))
		{
			return "There is no such user given id!!";
		}
		
		else 
		{
			productRepo.save(product);
			return product.toString() + " is saved!!";
		}
		
	}
	
	public String delete(int id)
	{
		if(productRepo.existsById(id))
		{
			Product del = productRepo.findById(id).get();
			productRepo.deleteById(id);
			return del.toString() + " is deleted!!";
		}
		
		else 
			return "No Such Product!!";
	}
	
	public String update(int id, Product product)
	{
		if(id != product.getId())
		{
			return "ids is not matched!!";
		}
		
		else if(customRepo.existsById(product.getOwnerId()) == false)
		{
			return "No such user given owner id!!";
		}
		
		else
		{
			productRepo.save(product);
			return "product is updated!!";
		}
	}
	
}
