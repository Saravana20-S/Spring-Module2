package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.service.ExceptionFlowService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario14")
public class ExceptionFlowController {

    private final ExceptionFlowService exceptionFlowService;

    public ExceptionFlowController(
            ExceptionFlowService exceptionFlowService) {

        this.exceptionFlowService =
                exceptionFlowService;
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(
            @PathVariable Long id) {

        System.out.println(
                "===== CONTROLLER EXECUTED ====="
        );

        return exceptionFlowService
                .getEmployeeById(id);
    }
}