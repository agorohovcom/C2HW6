package com.agorohov.employeebookspringwebapp.service;

import com.agorohov.employeebookspringwebapp.Employee;
import com.agorohov.employeebookspringwebapp.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookspringwebapp.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            employees.add(employee);
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует, добавление невозможно");
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет, удаление невозможно");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Нет такого сотрудника:" + employee);
        }
    }
}