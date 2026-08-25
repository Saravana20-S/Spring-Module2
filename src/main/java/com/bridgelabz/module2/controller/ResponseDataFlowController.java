package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.dto.EmployeeResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario13")
public class ResponseDataFlowController {

    @GetMapping("/employee")
    public ResponseEntity<EmployeeResponseDTO> getEmployee() {

        System.out.println(
                "===== CONTROLLER ====="
        );

        EmployeeResponseDTO employee =
                new EmployeeResponseDTO(
                        101L,
                        "Karthik",
                        50000
                );

        System.out.println(
                "EmployeeDTO created:"
        );

        System.out.println(
                employee
        );

        /*
         * Controller returns ResponseEntity.
         */
        return ResponseEntity.ok(
                employee
        );
    }
}