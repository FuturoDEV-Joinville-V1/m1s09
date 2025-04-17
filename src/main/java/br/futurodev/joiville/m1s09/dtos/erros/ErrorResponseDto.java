package br.futurodev.joiville.m1s09.dtos.erros;

public record ErrorResponseDto(
        String code,
        String message,
        String cause,
        String exceptionClassName
) {
}
