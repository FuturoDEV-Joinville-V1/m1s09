package br.futurodev.joiville.m1s09.errors.exceptions.notfounds;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(Long id) {
        super("Customer not found with id " + id);
    }
}
