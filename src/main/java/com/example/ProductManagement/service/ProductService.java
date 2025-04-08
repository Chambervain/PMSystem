package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.ProductCreationDto;
import com.example.ProductManagement.dto.ProductDto;
import java.util.List;

public interface ProductService {

    ProductCreationDto createProduct(ProductCreationDto productCreationDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto updatedProduct);

    void deleteProduct(Long id);

}
