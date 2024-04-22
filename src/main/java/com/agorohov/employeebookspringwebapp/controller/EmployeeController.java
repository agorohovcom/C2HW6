package com.agorohov.employeebookspringwebapp.controller;

import com.agorohov.employeebookspringwebapp.Employee;
import com.agorohov.employeebookspringwebapp.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookspringwebapp.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
        }
        return new Employee(firstName, lastName);
    }

    private static class Response {
        private final String message;

        public Response(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
