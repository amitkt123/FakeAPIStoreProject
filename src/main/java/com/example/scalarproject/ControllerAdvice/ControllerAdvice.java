package com.example.scalarproject.ControllerAdvice;

import com.example.scalarproject.DataTransfer.ExceptionDTO;
import com.example.scalarproject.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDTO> NotFoundExceptionMethod(NotFoundException notFoundExceptions){
        return new ResponseEntity<ExceptionDTO>(new ExceptionDTO(HttpStatus.NOT_FOUND.value(), notFoundExceptions.getMessage()),(HttpStatus.NOT_FOUND));
    }
}
