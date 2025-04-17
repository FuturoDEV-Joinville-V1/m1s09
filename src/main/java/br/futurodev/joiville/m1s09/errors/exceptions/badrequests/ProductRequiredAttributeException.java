package br.futurodev.joiville.m1s09.errors.exceptions.badrequests;

public class ProductRequiredAttributeException extends RequiredAttributeException {
    public ProductRequiredAttributeException(String attribute) {
        super("product", attribute);
    }
}
