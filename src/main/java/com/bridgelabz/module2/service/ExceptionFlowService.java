package com.bridgelabz.module2.service;

import com.bridgelabz.module2.exception.EmployeeNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class ExceptionFlowService {

    public String getEmployeeById(Long id) {

        System.out.println(
                "===== SERVICE EXECUTED ====="
        );

        System.out.println(
                "Searching employee: " + id
        );

        // Simulating employee not found

        throw new EmployeeNotFoundException(
                "Employee with ID "
                        + id
                        + " not found"
        );
    }
}