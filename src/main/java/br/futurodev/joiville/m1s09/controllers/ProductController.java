package br.futurodev.joiville.m1s09.controllers;

import br.futurodev.joiville.m1s09.dtos.products.ProductRequestDto;
import br.futurodev.joiville.m1s09.dtos.products.ProductResponseDto;
import br.futurodev.joiville.m1s09.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto post(@RequestBody ProductRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ProductResponseDto put(@PathVariable Long id, @RequestBody ProductRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
