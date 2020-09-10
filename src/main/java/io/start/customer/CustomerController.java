package io.start.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.start.product.Product;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
	@Autowired
	CustomService customService;
	
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		return customService.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable int id)
	{
		return customService.findById(id);
	}
	
	@GetMapping("/{id}/product")
	public List<Product> findProductGivenId(@PathVariable int id)
	{
		return customService.findProduct(id);
	}
	
	
	@PostMapping
	public String addCustomer(@RequestBody Customer customer)
	{
		return customService.save(customer);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		return customService.delete(id);
	}
	
	@PutMapping("/{id}")
	public String updateCustomer(@PathVariable int id, @RequestBody Customer customer)
	{
		return customService.updte(id, customer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
