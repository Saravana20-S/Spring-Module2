package com.bridgelabz.module2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(2)
public class JWTAuthenticationFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println(
                "===== JWT AUTHENTICATION FILTER ====="
        );

        String authorization =
                request.getHeader("Authorization");

        System.out.println(
                "Authorization: "
                        + authorization
        );

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

        /*
         * In a real application:
         *
         * 1. Extract JWT
         * 2. Validate signature
         * 3. Check expiration
         * 4. Extract username
         * 5. Create Authentication
         * 6. Put Authentication into
         *    SecurityContextHolder
         *
         * For Scenario 17 we are only
         * demonstrating the request flow.
         */

        System.out.println(
                "JWT token received"
        );

        filterChain.doFilter(
                request,
                response
        );
    }
}