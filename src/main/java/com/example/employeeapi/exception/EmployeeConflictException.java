package com.example.employeeapi.exception;

public class EmployeeConflictException extends RuntimeException{

    public EmployeeConflictException(String message){
        super(message);
    }
}
