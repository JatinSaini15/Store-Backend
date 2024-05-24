package com.javaguides.store.service.impl;

import com.javaguides.store.ProductMapper;
import com.javaguides.store.dto.ProductDto;
import com.javaguides.store.entity.Product;
import com.javaguides.store.exception.ResourceNotFoundException;
import com.javaguides.store.repository.ProductRepository;
import com.javaguides.store.service.ProductService;


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
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product does not exist with given SKU ID : " + productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Product does not exist with given SKU ID: " + productId)
        );

        product.setProductName(updatedProduct.getProductName());
        product.setQuantity(updatedProduct.getQuantity());
        product.setUnit(updatedProduct.getUnit());
        product.setPrice(updatedProduct.getPrice());
        product.setSupplier(updatedProduct.getSupplier());
        product.setCategory(updatedProduct.getCategory());

        Product updatedProductObj = productRepository.save(product);
        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Product does not exist with given SKU ID: " + productId)
        );

        productRepository.deleteById(productId);
    }
}
