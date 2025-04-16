package br.futurodev.joiville.m1s09.dtos.orders;

import br.futurodev.joiville.m1s09.dtos.products.ProductResponseDto;

import java.math.BigDecimal;

public record OrderItemResponseDto(
        Long id,
        ProductResponseDto product,
        BigDecimal quantity,
        BigDecimal price,
        BigDecimal total
) {
}
