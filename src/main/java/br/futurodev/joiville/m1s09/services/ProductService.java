package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.products.ProductRequestDto;
import br.futurodev.joiville.m1s09.dtos.products.ProductResponseDto;
import br.futurodev.joiville.m1s09.entities.Product;

import java.util.List;

public interface ProductService {

    // With DTOs
    List<ProductResponseDto> findAll();
    ProductResponseDto findById(Long id);
    ProductResponseDto create(ProductRequestDto dto);
    ProductResponseDto update(Long id, ProductRequestDto dto);
    void delete(Long id);

    // With Entities
    Product findEntityById(Long id);

}
