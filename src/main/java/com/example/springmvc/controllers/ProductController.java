package com.example.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmvc.models.Product;
import com.example.springmvc.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@ModelAttribute("module")
    String module() {
        return "products";
    }

    @GetMapping("/products")
    String productForm(Model model) {
    	model.addAttribute("product", new Product());
    	model.addAttribute("products", productService.listAll());
    	
        return "products/formProducts";
    }
    
    @PostMapping("/products")
    public String newProductSubmit(@ModelAttribute Product product, BindingResult bindingResult) {
        
    	if(bindingResult.hasErrors()){
            System.out.println("There was a error "+ bindingResult);
            System.out.println("Product is: "+ product.getName());
            return "index";
        }
    	
    	return "products/formProducts";
    }

}
