package br.futurodev.joiville.m1s09.errors.exceptions.notfounds;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(Long id) {
        super("Product not found with id " + id);
    }
}
