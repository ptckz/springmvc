package com.example.springmvc.services;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.example.springmvc.dto.Resume;
import com.example.springmvc.models.Account;
import com.example.springmvc.models.Product;
import com.example.springmvc.repositories.ProductRepository;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.delete(id);
	}

	public List<Product> listAll() {
		return productRepository.findAll();
	}
	
	public Long count() {
		return null;
	}

	public Long countProductsMax500() {
		return null;
	}
	public Long countProductsMax500WithFilter() {
		return null;
	}
	public Long countProductsMin500() {
		return null;
	}
	
	public Long countProductsMin500WithFilter() {
		return null;
	}
	
	public Long countPriceAllProducts() {
		return null;
	}

	public Product findById(Long id) {
		return productRepository.findOne(id);
	}
	
	public boolean isProductExist(Product product) {
		return productRepository.findByName(product.getName()) != null;
	}
}
