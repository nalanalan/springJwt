package com.java.SpringJwt.service;

import java.util.List;

import com.java.SpringJwt.model.Purchase;
import com.java.SpringJwt.repository.projection.PurchaseItem;

public interface PurchaseSevice {

	Purchase savePurchase(Purchase purchase);
	
	List<PurchaseItem> findPurchaseItemsOfUser(Long userId);



}
