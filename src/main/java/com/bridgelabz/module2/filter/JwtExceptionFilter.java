package com.bridgelabz.module2.filter;

import com.bridgelabz.module2.exception.JwtAuthenticationException;
import com.bridgelabz.module2.security.SecurityExceptionHandler;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtExceptionFilter extends OncePerRequestFilter {

    private final SecurityExceptionHandler
            securityExceptionHandler;

    public JwtExceptionFilter(
            SecurityExceptionHandler securityExceptionHandler) {

        this.securityExceptionHandler =
                securityExceptionHandler;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {

            System.out.println(
                    "===== JWT FILTER ====="
            );

            String authorization =
                    request.getHeader("Authorization");

            System.out.println(
                    "Authorization: "
                            + authorization
            );

            if (authorization == null ||
                    !authorization.startsWith("Bearer ")) {

                throw new JwtAuthenticationException(
                        "Missing or invalid JWT token"
                );
            }

            filterChain.doFilter(
                    request,
                    response
            );

        } catch (JwtAuthenticationException exception) {

            securityExceptionHandler
                    .handleAuthenticationException(
                            response,
                            exception
                    );
        }
    }
}