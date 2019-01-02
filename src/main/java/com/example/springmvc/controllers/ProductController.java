package com.example.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springmvc.models.Product;
import com.example.springmvc.services.ProductService;
import com.example.springmvc.services.ResumeService;
import com.example.springmvc.support.web.MessageHelper;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ResumeService resumeService;
	
	@ModelAttribute("module")
    String module() {
        return "products";
    }

    @GetMapping("/products")
    String findAll(Model model) {
    	model.addAttribute("product", new Product());
    	model.addAttribute("products", productService.listAll());
    	model.addAttribute("resumes", resumeService.listAllResumes());
    	
        return "products/formProducts";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String newProduct(@ModelAttribute Product product, Model model) {
    	
    	productService.createProduct(product);
    	
    	return findAll(model);
    }
    
    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProductForm(@PathVariable Long id, Model model) {
 
    	productService.deleteProductById(id);
    	
    	return findAll(model);
    }
    

}
