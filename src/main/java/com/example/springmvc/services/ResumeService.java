package com.example.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.example.springmvc.dto.Resume;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResumeService {

	@Autowired
	ProductService productService;
	
	public Resume listAllResumes() {
		
		Resume resume = new Resume();
			
		resume.setCountProducts(productService.count());
		resume.setCountProductsMax500(productService.countProductsMax500WithFilter());
		resume.setCountProductsMin500(productService.countProductsMin500WithFilter());
		resume.setCountPriceAllProducts(productService.countPriceAllProducts());

		return resume;
	}

}
