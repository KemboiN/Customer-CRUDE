package com.PrestoTechnologies.customerRegistration.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerRegisteredException.class)
    public ResponseEntity<ErrorDetails>handlesCustomerRegisteredException(CustomerRegisteredException exception, WebRequest request)
    {
        ErrorDetails errorDetails= ErrorDetails.builder()
                .timestamp(LocalDate.now())
                .code("200")
                .Message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
