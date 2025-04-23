package br.futurodev.joiville.m1s09.dtos.orders;

import br.futurodev.joiville.m1s09.dtos.customers.CustomerResponseDto;
import br.futurodev.joiville.m1s09.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponseDto(
        Long id,
        CustomerResponseDto customer,
        BigDecimal totalItems,
        BigDecimal discount,
        BigDecimal grandTotal,
        OrderStatus status,
        List<OrderItemResponseDto> items
) {
}
