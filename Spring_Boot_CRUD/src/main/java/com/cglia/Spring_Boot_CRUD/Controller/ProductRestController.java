
package com.cglia.Spring_Boot_CRUD.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.Spring_Boot_CRUD.Entity.Product;
import com.cglia.Spring_Boot_CRUD.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
      Logger logger= LoggerFactory.getLogger(ProductRestController.class);
      
      
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
    	logger.trace("Strarting get all products method with trace log level in controller class");
    	logger.info("Starting get all products method with info log level in controller class");
        return productService.getAllProducts();
    }

    @GetMapping("/getbyid/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN') ")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam("id") Long id) {
        if (!productService.deleteProduct(id)) {
            throw new RuntimeException("Product not found with id " + id);
        }
    }
}

