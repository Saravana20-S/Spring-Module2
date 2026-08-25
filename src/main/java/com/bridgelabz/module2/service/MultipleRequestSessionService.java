package com.bridgelabz.module2.service;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MultipleRequestSessionService {

    private static final String USERNAME =
            "USERNAME";

    private static final String USER_ID =
            "USER_ID";


    // ==========================================
    // CREATE USER SESSION
    // ==========================================

    public void createUserSession(
            HttpSession session,
            String username,
            int userId) {

        session.setAttribute(
                USERNAME,
                username
        );

        session.setAttribute(
                USER_ID,
                userId
        );

        System.out.println(
                "Server-side session created"
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
                session.getAttribute(
                        USERNAME
                );
    }


    // ==========================================
    // GET USER ID
    // ==========================================

    public Integer getUserId(
            HttpSession session) {

        return (Integer)
                session.getAttribute(
                        USER_ID
                );
    }
}