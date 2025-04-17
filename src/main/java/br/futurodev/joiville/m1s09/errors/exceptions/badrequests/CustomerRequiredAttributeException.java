package br.futurodev.joiville.m1s09.errors.exceptions.badrequests;

public class CustomerRequiredAttributeException extends RequiredAttributeException {
    public CustomerRequiredAttributeException(String attribute) {
        super("customer", attribute);
    }
}
