package com.example.employeeapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> employeeNotFoundHandler(EmployeeNotFoundException enfe) {
        return new ResponseEntity<>(getStringMessage(enfe.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeConflictException.class)
    public ResponseEntity<Object> employeeConflictHandler(EmployeeConflictException ece) {
        return new ResponseEntity<>(getStringMessage(ece.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmployeeGeneralException.class)
    public ResponseEntity<Object> employeeGeneralExceptionHandler(EmployeeGeneralException ege) {
        return new ResponseEntity<>(getStringMessage(ege.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //TODO: ASK FOR HTTP STATUS
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<Object> employeeAlreadyExistsHandler(EmployeeAlreadyExistsException eaee) {
        return new ResponseEntity<>(getStringMessage(eaee.getMessage()), HttpStatus.ALREADY_REPORTED);
    }

    //TODO: ASK QUESTION ABOUT THAT
    private Map<String, Object> getStringMessage(String message) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("time", LocalDateTime.now());
        body.put("message", message);
        return body;
    }
}
