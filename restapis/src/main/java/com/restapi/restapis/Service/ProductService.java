package com.restapi.restapis.Service;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.restapi.restapis.Repository.ProductRepository;
import com.restapi.restapis.Model.Product;
@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productrepo;
    //importing Product from model class and we are performing crud operation now
    public Product saveProduct(Product p){
        return productrepo.save(p); //invokes save() meythod predefined in JPA repository
    }

    public List<Product> listAll(){
        return productrepo.findAll();
    }
    public Optional<Product> getSingleProduct(long id){
        return productrepo.findById(id);
    }
    public void deleteProduct(long id){
        productrepo.deleteById(id);
    }
}
 