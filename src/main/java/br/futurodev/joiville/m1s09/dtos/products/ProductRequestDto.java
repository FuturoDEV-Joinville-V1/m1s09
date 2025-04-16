package br.futurodev.joiville.m1s09.dtos.products;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        String description,
        String sku,
        BigDecimal stockQuantity,
        BigDecimal price
) {
}
