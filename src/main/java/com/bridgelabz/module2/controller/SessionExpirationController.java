package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.service.SessionExpirationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario9")
public class SessionExpirationController {

    private final SessionExpirationService sessionExpirationService;

    public SessionExpirationController(
            SessionExpirationService sessionExpirationService) {

        this.sessionExpirationService =
                sessionExpirationService;
    }

    // ==========================================
    // LOGIN
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(
            HttpServletRequest request) {

        HttpSession session =
                request.getSession(true);

        sessionExpirationService.createSession(
                session,
                "Karthik"
        );

        return ResponseEntity.ok(
                "Login successful. Session created."
        );
    }


    // ==========================================
    // ACCOUNTS
    // ==========================================

    @GetMapping("/accounts")
    public ResponseEntity<String> accounts(
            HttpServletRequest request) {

        HttpSession session =
                request.getSession(false);

        if (session == null) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(
                            "Session expired. Please login again."
                    );
        }

        String username =
                sessionExpirationService
                        .getUsername(session);

        if (username == null) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(
                            "Session expired. Please login again."
                    );
        }

        return ResponseEntity.ok(
                "Welcome to accounts, "
                        + username
        );
    }
}