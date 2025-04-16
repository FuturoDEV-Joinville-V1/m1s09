package br.futurodev.joiville.m1s09.dtos.orders;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDto(
        Long customerId,
        BigDecimal discount,
        List<OrderItemRequestDto> items
) {
}
