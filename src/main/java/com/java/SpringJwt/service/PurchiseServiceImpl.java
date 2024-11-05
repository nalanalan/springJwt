package com.java.SpringJwt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.java.SpringJwt.model.Purchase;
import com.java.SpringJwt.repository.PurchaseRepository;
import com.java.SpringJwt.repository.projection.PurchaseItem;

@Service
@RequiredArgsConstructor
public class PurchiseServiceImpl implements PurchaseSevice{

	
	private final PurchaseRepository purchaseRepository;

	
	@Override
	public Purchase savePurchase(Purchase purchase) {
		purchase.setCreateTime(LocalDateTime.now());
		return purchaseRepository.save(purchase);
	}
	
	@Override
	public List<PurchaseItem> findPurchaseItemsOfUser(Long userId){
		return purchaseRepository.findAllPurchasesOfUser(userId);
	}
	
}
