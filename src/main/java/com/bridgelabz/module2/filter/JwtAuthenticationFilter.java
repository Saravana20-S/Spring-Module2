package com.bridgelabz.module2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("===== JWT FILTER STARTED =====");

        String authorization = request.getHeader("Authorization");

        System.out.println("Authorization: " + authorization);

        // JWT validation would happen here

        System.out.println("JWT validation completed");

        // IMPORTANT:
//        filterChain.doFilter(request, response);

        System.out.println("===== JWT FILTER ENDED =====");
    }
}