package com.java.SpringJwt.model;

import java.time.LocalDateTime;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="price", nullable = false)
	private Double price;
	
	@Column(name="create_time", nullable = false)
	private LocalDateTime createTime;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Purchase> purchaseListSet;

}
