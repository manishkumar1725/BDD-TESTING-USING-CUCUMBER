package com.example.cucumber_bdd;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Info")
public class Product {

	@Id
	int id;
	String name;

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
