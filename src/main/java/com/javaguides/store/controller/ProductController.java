package com.javaguides.store.controller;

import com.javaguides.store.ProductMapper;
import com.javaguides.store.dto.ProductDto;
import com.javaguides.store.service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    //Build Add Product Rest API
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto savedproduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
    }

    //Build Get product Rest API
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    //Build Get All products REST API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //Build Update product Rest API
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDto updateProduct){
        ProductDto productDto = productService.updateProduct(productId, updateProduct);
        return ResponseEntity.ok(productDto);
    }

    //Build Delete product Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product Deleted Successfully");
    }
}
