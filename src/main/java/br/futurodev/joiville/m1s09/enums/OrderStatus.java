package br.futurodev.joiville.m1s09.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ACTIVE("Active"), // index: 0
    INACTIVE("Inactive"); // index: 1

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

}
