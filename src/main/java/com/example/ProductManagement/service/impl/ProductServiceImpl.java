package com.example.ProductManagement.service.impl;

import com.example.ProductManagement.dto.ProductDto;
import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.exception.ResourceNotFoundException;
import com.example.ProductManagement.mapper.ProductMapper;
import com.example.ProductManagement.repository.ProductRepository;
import com.example.ProductManagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Unable to get the product, not existed with the given id: " + id));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((element) -> ProductMapper.mapToProductDto(element)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Unable to update the product, not existed with the given id: " + id));
        product.setName(updatedProduct.getName());
        product.setQuantity(updatedProduct.getQuantity());
        product.setDescription(updatedProduct.getDescription());

        Product returnedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(returnedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Unable to delete the product, not existed with the given id: " + id));

        productRepository.deleteById(id);
    }

}