package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.orders.OrderRequestDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderResponseDto;

import java.util.List;

public interface OrderService {

    List<OrderResponseDto> findAll();
    List<OrderResponseDto> findAllByProductName(String name);
    OrderResponseDto findById(Long id);
    OrderResponseDto create(OrderRequestDto orderRequestDto);
    OrderResponseDto cancel(Long id);

}
