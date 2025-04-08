package com.example.ProductManagement.mapper;

import com.example.ProductManagement.dto.ProductCreationDto;
import com.example.ProductManagement.dto.ProductDto;
import com.example.ProductManagement.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getQuantity(), product.getDescription());
    }

    public static Product mapToProduct(ProductDto productDto){
        Product prod = new Product();
        prod.setId(productDto.getId());
        prod.setName(productDto.getName());
        prod.setQuantity(productDto.getQuantity());
        prod.setDescription(productDto.getDescription());
        return prod;
    }

    public static Product mapToProductCreation(ProductCreationDto productCreationDto){
        Product prod = new Product();
        prod.setId(productCreationDto.getId());
        prod.setName(productCreationDto.getName());
        prod.setQuantity(productCreationDto.getQuantity());
        prod.setDescription(productCreationDto.getDescription());
        return prod;
    }

    public static ProductCreationDto mapToProductCreationDto(Product product){
        return new ProductCreationDto(product.getId(), product.getName(), product.getQuantity(), product.getDescription(), product.getOwner().getName());
    }

}