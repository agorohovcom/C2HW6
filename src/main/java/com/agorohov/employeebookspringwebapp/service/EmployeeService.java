package com.agorohov.employeebookspringwebapp.service;

import com.agorohov.employeebookspringwebapp.Employee;

public interface EmployeeService {
    // подумать над возвращаемым типом методов
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
