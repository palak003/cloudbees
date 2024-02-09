package com.example.cloudbees.Repository;

import com.example.cloudbees.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
