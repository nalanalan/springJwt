package com.java.SpringJwt.service;

import java.util.List;

import com.java.SpringJwt.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	void deleteProductById(Long id);

	List<Product> findAllProducts();

}
