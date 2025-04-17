package br.futurodev.joiville.m1s09.errors;

import br.futurodev.joiville.m1s09.dtos.erros.ErrorResponseDto;
import br.futurodev.joiville.m1s09.errors.exceptions.badrequests.RequiredAttributeException;
import br.futurodev.joiville.m1s09.errors.exceptions.notfounds.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handle(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrorResponseDto(
                "500",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> handle(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(RequiredAttributeException.class)
    public ResponseEntity<ErrorResponseDto> handle(RequiredAttributeException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(
                "400",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

}
