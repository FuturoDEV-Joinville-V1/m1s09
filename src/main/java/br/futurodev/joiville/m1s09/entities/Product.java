package br.futurodev.joiville.m1s09.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal stockQuantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

}
