package com.agorohov.employeebookspringwebapp.exception;

//@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
