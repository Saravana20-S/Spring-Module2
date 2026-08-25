package com.bridgelabz.module2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenario8")
public class CookieVsSessionController {

    // ==========================================
    // CREATE SESSION
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(
            HttpServletRequest request) {

        System.out.println(
                "===== SCENARIO 8 LOGIN ====="
        );

        /*
         * Create server-side session.
         */
        HttpSession session =
                request.getSession(true);

        /*
         * Store actual user information
         * inside the server-side session.
         */
        session.setAttribute(
                "USERNAME",
                "Karthik"
        );

        session.setAttribute(
                "USER_ID",
                101
        );

        session.setAttribute(
                "ROLE",
                "USER"
        );

        /*
         * Session ID
         */
        String sessionId =
                session.getId();

        System.out.println(
                "Session ID = " + sessionId
        );

        System.out.println(
                "Server-side session data:"
        );

        System.out.println(
                "USERNAME = Karthik"
        );

        System.out.println(
                "USER_ID = 101"
        );

        System.out.println(
                "ROLE = USER"
        );

        return ResponseEntity.ok(
                "Session created. "
                        + "Session ID = "
                        + sessionId
        );
    }


    // ==========================================
    // SHOW COOKIE AND SESSION
    // ==========================================

    @GetMapping("/compare")
    public ResponseEntity<String> compare(
            HttpServletRequest request) {

        System.out.println(
                "===== COOKIE VS SESSION ====="
        );

        /*
         * --------------------------------------
         * PART 1: READ COOKIE
         * --------------------------------------
         */

        Cookie[] cookies =
                request.getCookies();

        String jsessionId = null;

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                System.out.println(
                        "Cookie received: "
                                + cookie.getName()
                                + " = "
                                + cookie.getValue()
                );

                if ("JSESSIONID".equals(
                        cookie.getName())) {

                    jsessionId =
                            cookie.getValue();
                }
            }
        }

        /*
         * --------------------------------------
         * PART 2: READ SERVER SESSION
         * --------------------------------------
         */

        HttpSession session =
                request.getSession(false);

        if (session == null) {

            return ResponseEntity
                    .status(
                            HttpStatus.UNAUTHORIZED
                    )
                    .body(
                            "No server-side session found"
                    );
        }

        String sessionId =
                session.getId();

        String username =
                (String) session.getAttribute(
                        "USERNAME"
                );

        Integer userId =
                (Integer) session.getAttribute(
                        "USER_ID"
                );

        String role =
                (String) session.getAttribute(
                        "ROLE"
                );

        /*
         * --------------------------------------
         * DISPLAY COMPARISON
         * --------------------------------------
         */

        String result =
                "COOKIE\n"
                        + "JSESSIONID = "
                        + jsessionId
                        + "\n\n"

                        + "SESSION\n"
                        + "Session ID = "
                        + sessionId
                        + "\n"
                        + "USERNAME = "
                        + username
                        + "\n"
                        + "USER_ID = "
                        + userId
                        + "\n"
                        + "ROLE = "
                        + role;

        return ResponseEntity.ok(result);
    }


    // ==========================================
    // LOGOUT
    // ==========================================

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest request) {

        System.out.println(
                "===== SCENARIO 8 LOGOUT ====="
        );

        HttpSession session =
                request.getSession(false);

        if (session != null) {

            System.out.println(
                    "Destroying session: "
                            + session.getId()
            );

            session.invalidate();
        }

        return ResponseEntity.ok(
                "Session destroyed"
        );
    }
}