package com.bridgelabz.module2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario6")
public class CookieLoginController {

    /*
     * SCENARIO 6:
     * Cookie-Based Login
     *
     * Server sends:
     * Set-Cookie: SESSIONID=ABC123
     *
     * Browser/Postman stores it.
     *
     * Subsequent request:
     * Cookie: SESSIONID=ABC123
     */

    // ==========================================
    // LOGIN
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletResponse response) {

        System.out.println("===== COOKIE LOGIN =====");

        // Simple authentication for demonstration
        if (!username.equals("admin")
                || !password.equals("12345")) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

        /*
         * Create cookie
         */
        Cookie sessionCookie =
                new Cookie("SESSIONID", "ABC123");

        /*
         * Cookie configuration
         */
        sessionCookie.setHttpOnly(true);

        sessionCookie.setMaxAge(30 * 60);

        sessionCookie.setPath("/");

        /*
         * Add cookie to HTTP response.
         *
         * This produces:
         *
         * Set-Cookie: SESSIONID=ABC123
         */
        response.addCookie(sessionCookie);

        System.out.println(
                "Cookie created: SESSIONID=ABC123"
        );

        return ResponseEntity.ok(
                "Login successful. Cookie created."
        );
    }


    // ==========================================
    // ACCOUNT
    // ==========================================

    @GetMapping("/account")
    public ResponseEntity<String> account(
            HttpServletRequest request) {

        System.out.println("===== ACCOUNT REQUEST =====");

        /*
         * Read cookies sent by browser/Postman
         */
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("No cookies found. Please login.");
        }

        /*
         * Search for SESSIONID
         */
        for (Cookie cookie : cookies) {

            System.out.println(
                    "Cookie received: "
                            + cookie.getName()
                            + " = "
                            + cookie.getValue()
            );

            if ("SESSIONID".equals(cookie.getName())) {

                if ("ABC123".equals(cookie.getValue())) {

                    return ResponseEntity.ok(
                            "Welcome to your bank account"
                    );
                }

                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid SESSIONID");
            }
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("SESSIONID cookie not found");
    }


    // ==========================================
    // LOGOUT
    // ==========================================

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletResponse response) {

        System.out.println("===== COOKIE LOGOUT =====");

        /*
         * Create the same cookie
         * with MaxAge = 0.
         *
         * This tells the browser to delete it.
         */
        Cookie sessionCookie =
                new Cookie("SESSIONID", "");

        sessionCookie.setMaxAge(0);

        sessionCookie.setPath("/");

        response.addCookie(sessionCookie);

        return ResponseEntity.ok(
                "Logout successful. Cookie deleted."
        );
    }
}