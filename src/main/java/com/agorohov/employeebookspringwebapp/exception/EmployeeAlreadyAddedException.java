package com.agorohov.employeebookspringwebapp.exception;

//@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
