package com.cglia.Spring_Boot_CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cglia.Spring_Boot_CRUD.Entity.Product;

	public interface ProductRepository extends JpaRepository<Product, Long> { }

