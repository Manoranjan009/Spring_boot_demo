package com.cglia.Spring_Boot_CRUD.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.cglia.Spring_Boot_CRUD.Entity.Product;
import com.cglia.Spring_Boot_CRUD.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
	import java.util.Optional;

	@Service
	public class ProductService {
		
		Logger logger= LoggerFactory.getLogger(ProductService.class);
		
	    @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	    	List<Product> productlist = new ArrayList<>();
	    	try {
	    		logger.info(" get all employeesin service class started.");
	    		productlist = productRepository.findAll();
//	    		productlist = new ArrayList<>();
//	    		if(productlist.isEmpty()) {
//	    			throw new Exception();
//	    		}
//	    		logger.info(" getallproducts method in service class ended");
 	         }
	    	catch(Exception e){
	    		logger.error("Exception in getallproducts method of service class " );
	    		e.printStackTrace();
	    	}
	        return productlist;
	    }

	    public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Optional<Product> updateProduct(Long id, Product product) {
	        if (productRepository.existsById(id)) {
	            product.setId(id);
	            return Optional.of(productRepository.save(product));
	        }
	        return Optional.empty();
	    }

	    public boolean deleteProduct(Long id) {
	        if (productRepository.existsById(id)) {
	            productRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}


