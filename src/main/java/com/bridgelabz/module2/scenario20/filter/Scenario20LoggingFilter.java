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
@Order(0)
public class Scenario20LoggingFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println(
                "===== SCENARIO 20 LOGGING FILTER ====="
        );

        System.out.println(
                "HTTP Method: "
                        + request.getMethod()
        );

        System.out.println(
                "Request URI: "
                        + request.getRequestURI()
        );

        System.out.println(
                "Session ID: "
                        + request.getRequestedSessionId()
        );

        filterChain.doFilter(
                request,
                response
        );
    }
}