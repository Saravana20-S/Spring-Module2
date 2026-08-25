package com.bridgelabz.module2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario7")
public class SessionAuthenticationController {

    // ==========================================
    // LOGIN
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(
            HttpServletRequest request) {

        System.out.println(
                "===== SCENARIO 7 LOGIN ====="
        );

        /*
         * Create a new HTTP session.
         *
         * true means:
         * Create a session if one doesn't already exist.
         */
        HttpSession session =
                request.getSession(true);

        /*
         * Store user information
         * on the server-side session.
         */
        session.setAttribute(
                "USERNAME",
                "Karthik"
        );

        session.setAttribute(
                "USER_ID",
                101
        );

        /*
         * Get generated session ID.
         */
        String sessionId =
                session.getId();

        System.out.println(
                "Session ID: " + sessionId
        );

        System.out.println(
                "Server-side session created"
        );

        System.out.println(
                "Session mapping:"
        );

        System.out.println(
                sessionId + " → Karthik"
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

        System.out.println(
                "===== SCENARIO 7 PROFILE ====="
        );

        /*
         * Get the existing session.
         *
         * false means:
         * DO NOT create a new session.
         */
        HttpSession session =
                request.getSession(false);

        /*
         * No session means
         * user is not authenticated.
         */
        if (session == null) {

            System.out.println(
                    "No session found"
            );

            return ResponseEntity
                    .status(
                            HttpStatus.UNAUTHORIZED
                    )
                    .body(
                            "Please login first"
                    );
        }

        /*
         * Get session ID.
         */
        String sessionId =
                session.getId();

        System.out.println(
                "Received Session ID: "
                        + sessionId
        );

        /*
         * Retrieve user from
         * server-side session.
         */
        String username =
                (String) session.getAttribute(
                        "USERNAME"
                );

        Integer userId =
                (Integer) session.getAttribute(
                        "USER_ID"
                );

        /*
         * Validate session data.
         */
        if (username == null) {

            System.out.println(
                    "User information not found"
            );

            return ResponseEntity
                    .status(
                            HttpStatus.UNAUTHORIZED
                    )
                    .body(
                            "Invalid session"
                    );
        }

        System.out.println(
                "Session found"
        );

        System.out.println(
                "Session mapping:"
        );

        System.out.println(
                sessionId
                        + " → "
                        + username
        );

        return ResponseEntity.ok(
                "Profile belongs to "
                        + username
                        + " (User ID: "
                        + userId
                        + ")"
        );
    }


    // ==========================================
    // LOGOUT
    // ==========================================

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest request) {

        System.out.println(
                "===== SCENARIO 7 LOGOUT ====="
        );

        /*
         * Don't create a new session
         * during logout.
         */
        HttpSession session =
                request.getSession(false);

        if (session == null) {

            return ResponseEntity.ok(
                    "No active session"
            );
        }

        System.out.println(
                "Invalidating session: "
                        + session.getId()
        );

        /*
         * Destroy server-side session.
         */
        session.invalidate();

        return ResponseEntity.ok(
                "Logout successful"
        );
    }
}