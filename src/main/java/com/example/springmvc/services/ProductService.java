package com.example.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

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

	public Product findById(Long id) {
		return productRepository.findOne(id);
	}
	
	public boolean isProductExist(Product product) {
		return productRepository.findByName(product.getName()) != null;
	}
}
