package br.futurodev.joiville.m1s09.dtos.customers;

public record CustomerRequestDto(
        String username,
        String name,
        String taxId,
        String contact,
        String address
) {
}
