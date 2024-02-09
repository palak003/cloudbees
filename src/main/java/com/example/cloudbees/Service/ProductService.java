package com.example.cloudbees.Service;

import com.example.cloudbees.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Optional<Product> getProductById(Long productId);
    List<Product> getAllProducts();
    boolean updateProduct(Long productId, Product product);
    boolean deleteProduct(Long productId);
    boolean applyDiscountOrTax(Long productId, boolean isDiscount, double value);
}
