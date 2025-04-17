package br.futurodev.joiville.m1s09.errors.exceptions.notfounds;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id " + id);
    }
}
