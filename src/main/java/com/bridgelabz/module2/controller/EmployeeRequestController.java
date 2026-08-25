package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.dto.EmployeeRequestDTO;
import com.bridgelabz.module2.entity.Employee;
import com.bridgelabz.module2.service.EmployeeRequestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario11/employees")
public class EmployeeRequestController {

    private final EmployeeRequestService employeeService;

    public EmployeeRequestController(
            EmployeeRequestService employeeService) {

        this.employeeService =
                employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody EmployeeRequestDTO requestDTO) {

        System.out.println(
                "===== CONTROLLER ====="
        );

        System.out.println(
                "EmployeeRequestDTO received"
        );

        Employee employee =
                employeeService.createEmployee(
                        requestDTO
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employee);
    }
}