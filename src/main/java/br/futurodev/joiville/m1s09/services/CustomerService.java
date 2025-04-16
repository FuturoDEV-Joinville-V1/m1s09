package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.customers.CustomerRequestDto;
import br.futurodev.joiville.m1s09.dtos.customers.CustomerResponseDto;
import br.futurodev.joiville.m1s09.entities.Customer;

import java.util.List;

public interface CustomerService {

    // With DTOs
    List<CustomerResponseDto> findAll();
    CustomerResponseDto findById(Long id);
    CustomerResponseDto create(CustomerRequestDto dto);
    CustomerResponseDto update(Long id, CustomerRequestDto dto);
    void delete(Long id);

    // With Entities
    Customer findEntityById(Long id);

}
