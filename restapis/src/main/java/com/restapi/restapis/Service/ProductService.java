package com.restapi.restapis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import com.restapi.restapis.Repository.ProductRepository;
import com.restapi.restapis.Model.Product;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productrepo;

    // Save product
    public Product saveProduct(Product p){
        try {
            return productrepo.save(p);
        } catch (Exception e) {
            // Handle and log the exception
            System.err.println("Error saving product: " + e.getMessage());
            return null; // or throw a custom exception
        }
    }

    // List all products
    public List<Product> listAll(){
        try {
            return productrepo.findAll();
        } catch (Exception e) {
            // Handle and log the exception
            System.err.println("Error listing products: " + e.getMessage());
            return null; // or return Collections.emptyList();
        }
    }

    // Get single product by id
    public Optional<Product> getSingleProduct(long id){
        try {
            return productrepo.findById(id);
        } catch (Exception e) {
            // Handle and log the exception
            System.err.println("Error finding product by id: " + e.getMessage());
            return Optional.empty(); // or throw a custom exception
        }
    }

    // Delete product by id
    public void deleteProduct(long id){
        try {
            productrepo.deleteById(id);
        } catch (Exception e) {
            // Handle and log the exception
            System.err.println("Error deleting product: " + e.getMessage());
            // Throwing runtime exception might be useful to indicate the failure to the caller
            throw new RuntimeException("Error deleting product: " + e.getMessage());
        }
    }
}