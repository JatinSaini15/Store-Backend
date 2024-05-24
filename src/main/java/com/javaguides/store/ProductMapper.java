package com.javaguides.store;

import com.javaguides.store.dto.ProductDto;
import com.javaguides.store.entity.Product;
public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(

                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getUnit(),
                product.getPrice(),
                product.getSupplier(),
                product.getCategory()

        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(

                productDto.getId(),
                productDto.getProductName(),
                productDto.getQuantity(),
                productDto.getUnit(),
                productDto.getPrice(),
                productDto.getSupplier(),
                productDto.getCategory()
        );
    }
}





