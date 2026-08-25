package com.bridgelabz.module2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String requestId = UUID.randomUUID().toString();

        System.out.println("===== FILTER =====");
        System.out.println("Request ID: " + requestId);
        System.out.println("Request URI: " + request.getRequestURI());

        request.setAttribute("requestId", requestId);

        filterChain.doFilter(request, response);

        System.out.println("Response completed for Request ID: " + requestId);
    }
}