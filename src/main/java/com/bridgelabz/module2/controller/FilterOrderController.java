package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.security.SecurityContext;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario16")
public class FilterOrderController {

    @GetMapping("/profile")
    public String profile() {

        System.out.println(
                "===== CONTROLLER ====="
        );

        return "Welcome "
                + SecurityContext.getUser();
    }
}