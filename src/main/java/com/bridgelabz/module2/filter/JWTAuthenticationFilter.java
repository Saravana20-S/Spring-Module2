package com.bridgelabz.module2.filter;

import com.bridgelabz.module2.security.SecurityContext;

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
public class JWTAuthenticationFilter extends OncePerRequestFilter {

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

        if (authorization != null &&
                authorization.startsWith("Bearer ")) {

            /*
             * Normally:
             *
             * JWT
             *   ↓
             * validate token
             *   ↓
             * extract username
             *
             * For demonstration:
             */
            String username = "Karthik";

            SecurityContext.setUser(
                    username
            );

            System.out.println(
                    "Authenticated user: "
                            + username
            );
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}