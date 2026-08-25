package com.bridgelabz.module2.service;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class SessionExpirationService {

    private static final String USERNAME =
            "USERNAME";


    // ==========================================
    // CREATE SESSION DATA
    // ==========================================

    public void createSession(
            HttpSession session,
            String username) {

        session.setAttribute(
                USERNAME,
                username
        );

        System.out.println(
                "Session created"
        );

        System.out.println(
                "Session ID: "
                        + session.getId()
        );

        System.out.println(
                "User: "
                        + username
        );
    }


    // ==========================================
    // GET USERNAME
    // ==========================================

    public String getUsername(
            HttpSession session) {

        return (String)
                session.getAttribute(USERNAME);
    }
}