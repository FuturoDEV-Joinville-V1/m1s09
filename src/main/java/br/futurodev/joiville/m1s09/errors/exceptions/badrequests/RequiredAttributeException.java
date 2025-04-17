package br.futurodev.joiville.m1s09.errors.exceptions.badrequests;

public abstract class RequiredAttributeException extends RuntimeException {
    RequiredAttributeException(String objectName, String attribute) {
        super("Required attribute '" + objectName + "." + attribute + "' is not present");
    }
}
