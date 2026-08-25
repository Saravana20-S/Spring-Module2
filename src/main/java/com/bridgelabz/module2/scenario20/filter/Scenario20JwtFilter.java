package com.bridgelabz.module2.scenario20.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class Scenario20JwtFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println(
                "===== SCENARIO 20 JWT FILTER ====="
        );

        String authorization =
                request.getHeader("Authorization");

        /*
         * No JWT
         */

        if (authorization == null ||
                !authorization.startsWith("Bearer ")) {

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
                      "message": "JWT token is missing"
                    }
                    """
            );

            return;
        }

        String token =
                authorization.substring(7);

        System.out.println(
                "JWT received: "
                        + token
        );

        /*
         * In a real application:
         *
         * 1. Validate signature
         * 2. Check expiration
         * 3. Extract username
         * 4. Extract roles
         * 5. Create Authentication
         * 6. Store Authentication in
         *    SecurityContextHolder
         */

        filterChain.doFilter(
                request,
                response
        );
    }
}