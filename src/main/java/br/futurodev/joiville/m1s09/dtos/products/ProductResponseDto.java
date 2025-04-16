package br.futurodev.joiville.m1s09.dtos.products;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        String description,
        String sku,
        BigDecimal stockQuantity,
        BigDecimal price
) {
}
