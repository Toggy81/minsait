package com.minsait.demo.exception.handler;

import com.minsait.demo.exception.ErrorMessage;
import com.minsait.demo.exception.PriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(PriceException.class)
    public ResponseEntity<ErrorMessage> PriceException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(String.valueOf(HttpStatus.NOT_FOUND.value()), "No se encontró lista de precios para la búsqueda solicitada."));
    }

}