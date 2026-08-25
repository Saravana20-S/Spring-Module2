package com.bridgelabz.module2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Scenario3Controller {

    @GetMapping("/scenario3/test")
    public String test(HttpServletRequest request) {

        String requestId =
                (String) request.getAttribute("requestId");

        System.out.println("===== CONTROLLER =====");
        System.out.println("Controller executed");

        return "Request successful. Request ID: " + requestId;
    }
}