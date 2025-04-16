package br.futurodev.joiville.m1s09.dtos.orders;

import java.math.BigDecimal;

public record OrderItemRequestDto(
        Long productId,
        BigDecimal quantity
) {
}
