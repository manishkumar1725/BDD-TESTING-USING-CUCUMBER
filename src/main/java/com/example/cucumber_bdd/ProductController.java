package com.example.cucumber_bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	
	@Autowired
	ProductService service;
	
	@GetMapping(value="/getProduct/{id}")
	public Optional<Product> getProduct(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping(value = "/getAllProduct")
	public List<Product> getAll(){
		
		return service.getAllProduct();
	}
	
	@PostMapping(value = "/addProduct")
	public String addProduct(@RequestBody Product product)
	{
		return service.addProduct(product);
	}
	
	@DeleteMapping(value ="/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	

}
