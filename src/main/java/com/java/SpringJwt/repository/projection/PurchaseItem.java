package com.java.SpringJwt.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
	
	String getName();
	Double getPrice();
	LocalDateTime getPurchaseTime();

}
