package com.restapi.restapis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.restapis.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}