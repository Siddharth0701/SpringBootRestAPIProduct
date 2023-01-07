package com.ecomproductms.ecomproductms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomproductms.ecomproductms.model.Product;
import com.ecomproductms.ecomproductms.productdao.ProductDao;

@Component
public class ProductServices {
    @Autowired
    private ProductDao productDao;

    // get all products
    public List<Product> getAllProduct() {
        List<Product> list = (List<Product>) this.productDao.findAll();
        return list;
    }

    // get single product by id
    public Product getProductById(int id) {
        Product product = null;
        try {
            product = this.productDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    //Add product
    public Product addProduct(Product p){
        Product result=productDao.save(p);
        return result;
    }
    //delete product
    public void deleteProduct( int productId){
        this.productDao.deleteById(productId);

    }
    //update product by id
    public void updateProduct(Product product, int productId){
        product.setProductId(productId);
        productDao.save(product);

    }

}
