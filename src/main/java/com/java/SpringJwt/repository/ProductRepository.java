package com.java.SpringJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringJwt.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
