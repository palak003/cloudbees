package com.example.cloudbees.Service.serviceImpl;

import com.example.cloudbees.Entity.Product;
import com.example.cloudbees.Repository.ProductRepository;
import com.example.cloudbees.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean updateProduct(Long productId, Product product) {
        Optional<Product> existingProductOptional = getProductById(productId);
        if (existingProductOptional.isPresent()) {
            product.setProductId(productId);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        Optional<Product> existingProductOptional = getProductById(productId);
        if (existingProductOptional.isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public boolean applyDiscountOrTax(Long productId, boolean isDiscount, double value) {
        Optional<Product> existingProductOptional = getProductById(productId);
        if (existingProductOptional.isPresent()) {
            Product product = existingProductOptional.get();
            double price = product.getPrice();
            if (isDiscount) {
                double discountedPrice = price - (price * (value / 100));
                product.setPrice(discountedPrice);
            } else {
                double taxedPrice = price + (price * (value / 100));
                product.setPrice(taxedPrice);
            }
            updateProduct(productId, product);
            return true;
        }
        return false;
    }

}