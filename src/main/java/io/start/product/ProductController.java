package io.start.product;

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

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProducts()
	{
		return (List<Product>) productService.findAll();
	}
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id)
	{
		return  productService.findById(id);
	}
	
	@PostMapping
	public String saveProduct(@RequestBody Product product)
	{
		
		return productService.save(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return productService.delete(id);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		return productService.update(id, product);
	}
	
	
}
