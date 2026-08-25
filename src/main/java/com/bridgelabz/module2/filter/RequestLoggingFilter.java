package com.bridgelabz.module2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("========== FILTER START ==========");

        System.out.println("Request Method: " + request.getMethod());

        System.out.println("Request URI: " + request.getRequestURI());

        System.out.println("Request reached Filter");

        filterChain.doFilter(request, response);

        System.out.println("Response Status: " + response.getStatus());

        System.out.println("========== FILTER END ==========");
    }
}