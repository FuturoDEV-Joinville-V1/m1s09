package br.futurodev.joiville.m1s09.errors.exceptions.badrequests;

public class OrderRequiredAttributeException extends RequiredAttributeException {
    public OrderRequiredAttributeException(String attribute) {
        super("order", attribute);
    }
}
