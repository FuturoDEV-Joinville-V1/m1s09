package br.futurodev.joiville.m1s09.errors.exceptions.notfounds;

public abstract class NotFoundException extends RuntimeException {
    NotFoundException(String message) {
        super(message);
    }
}
