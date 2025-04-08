package com.example.ProductManagement.repository;

import com.example.ProductManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByOwnerName(String ownerName);

}