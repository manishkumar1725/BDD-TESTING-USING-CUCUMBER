package com.example.cucumber_bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	
	@Autowired
	ProductRepository repository;
	
	public Optional<Product> getProductById(int id)
	{
		return repository.findById(id);
	}
	
	public List<Product> getAllProduct()
	{
		return repository.findAll();
	}
	
	public String addProduct(Product product)
	{
		repository.save(product);
		return "Product added";
	}
	
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Product deleted";
	}

}
