package br.futurodev.joiville.m1s09.dtos.customers;

public record CustomerResponseDto(
        Long id,
        String name,
        String taxId,
        String contact,
        String address
) {
}
