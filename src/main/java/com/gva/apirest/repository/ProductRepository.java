package com.gva.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gva.apirest.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}