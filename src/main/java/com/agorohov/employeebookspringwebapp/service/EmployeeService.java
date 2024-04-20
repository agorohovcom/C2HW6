package com.agorohov.employeebookspringwebapp.service;

import com.agorohov.employeebookspringwebapp.Employee;
import com.agorohov.employeebookspringwebapp.exception.ArrayIsFull;
import com.agorohov.employeebookspringwebapp.exception.EmployeeAlreadyAdded;
import com.agorohov.employeebookspringwebapp.exception.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public boolean addEmployee(String firstName, String lastName) throws ArrayIsFull, EmployeeAlreadyAdded {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            return employees.add(employee);
        } else {
            throw new EmployeeAlreadyAdded("Данный сотрудник уже добавлен");
        }
    }

    public boolean removeEmployee(String firstName, String lastName) throws EmployeeNotFound {
        return employees.remove(new Employee(firstName, lastName));
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFound("Нет такого сотрудника:" + employee);
        }
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
