package com.agorohov.employeebookspringwebapp.controller;

import com.agorohov.employeebookspringwebapp.Employee;
import com.agorohov.employeebookspringwebapp.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookspringwebapp.exception.EmployeeNotFoundException;
import com.agorohov.employeebookspringwebapp.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @ExceptionHandler({EmployeeAlreadyAddedException.class, EmployeeNotFoundException.class})
    public String handleEmployeeNotFoundException(RuntimeException e) {
        e.printStackTrace();
        return e.getMessage();
    }

//    private static class Response {
//        private final String message;
//
//        public Response(String message) {
//            this.message = message;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//    }
}
