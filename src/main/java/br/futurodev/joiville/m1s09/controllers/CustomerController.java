package br.futurodev.joiville.m1s09.controllers;

import br.futurodev.joiville.m1s09.dtos.customers.CustomerRequestDto;
import br.futurodev.joiville.m1s09.dtos.customers.CustomerResponseDto;
import br.futurodev.joiville.m1s09.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto post(@RequestBody CustomerRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public CustomerResponseDto put(@PathVariable Long id, @RequestBody CustomerRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }

}
