package com.restapi.restapis.Model;

import org.springframework.data.annotation.Id;
import jakarta.persistence.*;



@Entity
public class Product {
    // @SequenceGenerator(name="product_seq", initialValue = 1000,allocationsize =1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//, generator="product_seq")
    private Long pid;
    private String brand;
    private String pname;
    @Column(nullable = false)
    private String madein;
    private float price;


    //created a default constructor
    public Product() {
    }

    //created constructors for the given no. of fields
    public Product(Long pid, String brand, String madein, String pname,float price) {
        this.pid = pid;
        this.brand = brand;
        this.pname = pname;
        this.madein = madein;
        this.price = price;
    }

    //here we created getters and setters for all the given fields
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String pname){
        this.pname = pname;
    }

    public String getName(){
        return pname;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
}
