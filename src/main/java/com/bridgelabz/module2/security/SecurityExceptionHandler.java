package com.bridgelabz.module2.security;

import com.bridgelabz.module2.exception.JwtAuthenticationException;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityExceptionHandler {

    public void handleAuthenticationException(
            HttpServletResponse response,
            JwtAuthenticationException exception)
            throws IOException {

        System.out.println(
                "===== SECURITY EXCEPTION HANDLER ====="
        );

        response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
        );

        response.setContentType(
                "application/json"
        );

        response.getWriter().write(
                """
                {
                    "status": 401,
                    "error": "UNAUTHORIZED",
                    "message": "%s"
                }
                """.formatted(
                        exception.getMessage()
                )
        );
    }
}