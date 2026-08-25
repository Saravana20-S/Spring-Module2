package com.bridgelabz.module2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenario5")
public class Scenario5Controller {

    @GetMapping("/test")
    public String test() {

        System.out.println("===== CONTROLLER EXECUTED =====");

        return "Controller reached successfully";
    }
}
