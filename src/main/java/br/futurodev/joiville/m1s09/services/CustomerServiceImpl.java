package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.customers.CustomerRequestDto;
import br.futurodev.joiville.m1s09.dtos.customers.CustomerResponseDto;
import br.futurodev.joiville.m1s09.entities.Customer;
import br.futurodev.joiville.m1s09.errors.exceptions.badrequests.CustomerRequiredAttributeException;
import br.futurodev.joiville.m1s09.errors.exceptions.notfounds.CustomerNotFoundException;
import br.futurodev.joiville.m1s09.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        List<Customer> customers = repository.findAll();
        List<CustomerResponseDto> response = new ArrayList<>();

        for (Customer customer : customers) {
            response.add(new CustomerResponseDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getTaxId(),
                    customer.getContact(),
                    customer.getAddress()
            ));
        }

        return response;
    }

    @Override
    public CustomerResponseDto findById(Long id) {
        Customer customer = findEntityById(id);
        if (customer != null) {
            return new CustomerResponseDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getTaxId(),
                    customer.getContact(),
                    customer.getAddress()
            );
        }
        return null;
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto dto) {
        return save(new Customer(), dto);
    }

    @Override
    public CustomerResponseDto update(Long id, CustomerRequestDto dto) {
        Customer customer = findEntityById(id);
        return save(customer, dto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public CustomerResponseDto save(Customer customer, CustomerRequestDto dto) {

        validateDto(dto);

        customer.setUsername(dto.username());
        customer.setName(dto.name());
        customer.setTaxId(dto.taxId());
        customer.setContact(dto.contact());
        customer.setAddress(dto.address());

        customer = repository.save(customer);

        return new CustomerResponseDto(
                customer.getId(),
                customer.getName(),
                customer.getTaxId(),
                customer.getContact(),
                customer.getAddress()
        );
    }

    private void validateDto(CustomerRequestDto dto) {
        if (!StringUtils.hasText(dto.username())) {
            throw new CustomerRequiredAttributeException("username");
        }
        if (!StringUtils.hasText(dto.name())) {
            throw new CustomerRequiredAttributeException("name");
        }
        if (!StringUtils.hasText(dto.taxId())) {
            throw new CustomerRequiredAttributeException("taxId");
        }
        if (!StringUtils.hasText(dto.address())) {
            throw new CustomerRequiredAttributeException("address");
        }
    }

}
