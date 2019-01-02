package com.example.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springmvc.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(String name);
	
    @Query("SELECT COUNT(p.id) FROM Product p WHERE p.price >= 500")
    Long countProductsMax500();
    
    @Query("SELECT COUNT(p.id) FROM Product p WHERE p.price <= 500")
    Long countProductsMin500();
    
}
