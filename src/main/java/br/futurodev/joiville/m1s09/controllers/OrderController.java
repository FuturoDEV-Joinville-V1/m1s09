package br.futurodev.joiville.m1s09.controllers;

import br.futurodev.joiville.m1s09.dtos.orders.OrderRequestDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderResponseDto;
import br.futurodev.joiville.m1s09.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("products/name/{name}")
    public List<OrderResponseDto> getByProductName(@PathVariable String name) {
        return service.findAllByProductName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto post(@RequestBody OrderRequestDto dto) {
        return service.create(dto);
    }

    @PatchMapping("{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable Long id) {
        service.cancel(id);
    }

}
