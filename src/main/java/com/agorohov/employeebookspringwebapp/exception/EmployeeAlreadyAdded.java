package com.agorohov.employeebookspringwebapp.exception;

public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
