package com.java.SpringJwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.java.SpringJwt.model.Purchase;
import com.java.SpringJwt.service.PurchaseSevice;


@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {
	
	
	private final PurchaseSevice purchaseSevice; 
	
	
	@PostMapping
	public ResponseEntity<?>savePurchase(@RequestBody Purchase purchase){
		
		return new ResponseEntity<>(purchaseSevice.savePurchase(purchase),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?>getAllPurchaseOfUser(@PathVariable("userId") Long userId){
		
		return new ResponseEntity<>(purchaseSevice.findPurchaseItemsOfUser(userId), HttpStatus.OK);
	}
	

}
