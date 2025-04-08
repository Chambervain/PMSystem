package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto updatedProduct);

    void deleteProduct(Long id);

}
