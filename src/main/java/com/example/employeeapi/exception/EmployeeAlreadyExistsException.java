package com.example.employeeapi.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{

    public EmployeeAlreadyExistsException(String message){
        super(message);
    }
}
