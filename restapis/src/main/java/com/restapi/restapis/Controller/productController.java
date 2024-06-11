package com.restapi.restapis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapis.Exception.ResourceNotFoundException;
import com.restapi.restapis.Model.Product;
import com.restapi.restapis.Service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(value ="/api")
public class productController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
    @Autowired
    private ProductService pservice;
    
    @PostMapping("/products")    
    public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product){
        try{
            Product p = pservice.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    } 

    //all layers will use Model when required
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = pservice.listAll();
            return ResponseEntity.ok(products);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value ="id")Long pId) throws ResourceNotFoundException{
        Product p = pservice.getSingleProduct(pId).orElseThrow(()-> new ResourceNotFoundException("Product Not Found fro this id"));
        return ResponseEntity.ok().body(p);
    }
}
