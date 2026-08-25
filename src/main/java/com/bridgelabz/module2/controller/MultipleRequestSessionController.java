package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.service.MultipleRequestSessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario10")
public class MultipleRequestSessionController {

    private final MultipleRequestSessionService sessionService;

    public MultipleRequestSessionController(
            MultipleRequestSessionService sessionService) {

        this.sessionService = sessionService;
    }


    // ==========================================
    // LOGIN
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(
            HttpServletRequest request) {

        System.out.println(
                "===== SCENARIO 10 LOGIN ====="
        );

        HttpSession session =
                request.getSession(true);

        sessionService.createUserSession(
                session,
                "Karthik",
                101
        );

        return ResponseEntity.ok(
                "Login successful. Session created."
        );
    }


    // ==========================================
    // PROFILE
    // ==========================================

    @GetMapping("/profile")
    public ResponseEntity<String> profile(
            HttpServletRequest request) {

        return processRequest(
                request,
                "PROFILE"
        );
    }


    // ==========================================
    // ORDERS
    // ==========================================

    @GetMapping("/orders")
    public ResponseEntity<String> orders(
            HttpServletRequest request) {

        return processRequest(
                request,
                "ORDERS"
        );
    }


    // ==========================================
    // PAYMENTS
    // ==========================================

    @GetMapping("/payments")
    public ResponseEntity<String> payments(
            HttpServletRequest request) {

        return processRequest(
                request,
                "PAYMENTS"
        );
    }


    // ==========================================
    // NOTIFICATIONS
    // ==========================================

    @GetMapping("/notifications")
    public ResponseEntity<String> notifications(
            HttpServletRequest request) {

        return processRequest(
                request,
                "NOTIFICATIONS"
        );
    }


    // ==========================================
    // COMMON SESSION CHECK
    // ==========================================

    private ResponseEntity<String> processRequest(
            HttpServletRequest request,
            String resource) {

        /*
         * false means:
         * Don't create a new session.
         *
         * We only want to retrieve
         * the existing logged-in session.
         */
        HttpSession session =
                request.getSession(false);

        if (session == null) {

            System.out.println(
                    "No active session"
            );

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(
                            "Session expired. Please login."
                    );
        }

        String username =
                sessionService.getUsername(
                        session
                );

        if (username == null) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(
                            "User not found in session"
                    );
        }

        String sessionId =
                session.getId();

        System.out.println(
                "Request: " + resource
        );

        System.out.println(
                "Session ID: " + sessionId
        );

        System.out.println(
                "User: " + username
        );

        return ResponseEntity.ok(
                resource
                        + " request belongs to "
                        + username
                        + " | Session ID: "
                        + sessionId
        );
    }
}