package com.ecomproductms.ecomproductms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomproductms.ecomproductms.model.*;

import com.ecomproductms.ecomproductms.services.ProductServices;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductss() {
        try {
            List<Product> list = this.productServices.getAllProduct();
            if (list.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(list);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    // get product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = this.productServices.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(product));
    }

    // add product by post method
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product p = null;
        try {
            p = this.productServices.addProduct(product);
            System.out.println(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // delete product handeler
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId) {
        try {
            this.productServices.deleteProduct(productId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    //update product handeler
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("productId") int productId) {
        try {
            this.productServices.updateProduct(product, productId);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        
        
    }


}
