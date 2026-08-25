package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.dto.EmployeeDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario12")
public class RequestBodyController {

    @PostMapping("/employees")
    public ResponseEntity<String> create(
            @RequestBody EmployeeDTO dto) {

        System.out.println(
                "===== CONTROLLER EXECUTED ====="
        );

        System.out.println(
                "DTO received: " + dto
        );

        System.out.println(
                "Name: " + dto.getName()
        );

        System.out.println(
                "Salary: " + dto.getSalary()
        );

        return ResponseEntity.ok(
                "Employee received successfully: "
                        + dto
        );
    }
}