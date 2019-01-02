package com.example.springmvc.dto;

public class Resume {

	private Long countProducts;
	private Long countProductsMax500;
	private Long countProductsMin500;
	private Long countPriceAllProducts;
	
	public Resume() {
		
	}
	
	public Long getCountProducts() {
		return countProducts;
	}
	public void setCountProducts(Long countProducts) {
		this.countProducts = countProducts;
	}

	public Long getCountProductsMax500() {
		return countProductsMax500;
	}

	public void setCountProductsMax500(Long countProductsMax500) {
		this.countProductsMax500 = countProductsMax500;
	}

	public Long getCountProductsMin500() {
		return countProductsMin500;
	}

	public void setCountProductsMin500(Long countProductsMin500) {
		this.countProductsMin500 = countProductsMin500;
	}

	public Long getCountPriceAllProducts() {
		return countPriceAllProducts;
	}

	public void setCountPriceAllProducts(Long countPriceAllProducts) {
		this.countPriceAllProducts = countPriceAllProducts;
	}
	
}
