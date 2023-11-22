package com.okavango.parking_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //retorno para recurso nao encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {

        // instante atual com menos 3 horas
        Instant moment = Instant.now().minus(3, ChronoUnit.HOURS);
        String message = ex.getMessage();
        APIError apiError = new APIError(moment, HttpStatus.NOT_FOUND.value(), message);

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }


}
