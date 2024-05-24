package com.javaguides.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name", nullable = false, unique = true)
    private String productName;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="unit")
    private String unit;

    @Column(name="price")
    private Double price;

    @Column(name="supplier")
    private String supplier;

    @Column(name="category")
    private String category;
}
