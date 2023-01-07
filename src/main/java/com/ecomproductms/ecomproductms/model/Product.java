package com.ecomproductms.ecomproductms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private int productQuantity;
    private double productPrice;

    public Product() {
        super();
    }
    public Product(int productId, String productName, int productQuantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
                + productQuantity + ", productPrice=" + productPrice + "]";
    }
    
    

    
    

}
