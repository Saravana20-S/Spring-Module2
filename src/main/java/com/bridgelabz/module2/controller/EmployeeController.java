package com.bridgelabz.module2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees/{id}")
    public String getEmployeeById(@PathVariable Long id) {

        return "Employee ID: " + id;
    }
}