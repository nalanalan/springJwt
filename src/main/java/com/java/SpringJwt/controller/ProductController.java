package com.java.SpringJwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.java.SpringJwt.model.Product;
import com.java.SpringJwt.service.ProductService;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;  // final kullanılmadığında productservice is null hatası veriyor
	
	@PostMapping ///api/product
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
		
		
	}
	
	@DeleteMapping("{productId}")  ///api/product/{productId}
	public ResponseEntity<?> deleteByProductId(@PathVariable Long productId){
		
		productService.deleteProductById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?>  getAllProduct() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}
	
}
