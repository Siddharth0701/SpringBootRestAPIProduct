package com.ecomproductms.ecomproductms.productdao;

import org.springframework.data.repository.CrudRepository;

import com.ecomproductms.ecomproductms.model.Product;

public interface ProductDao extends CrudRepository<Product,Integer> {
    public Product findById(int id);
    
}
