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
@Order(3)
public class SecurityFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println(
                "===== SECURITY FILTER ====="
        );

        String currentUser =
                SecurityContext.getUser();

        System.out.println(
                "Authenticated user: "
                        + currentUser
        );

        if (currentUser == null) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            response.getWriter().write(
                    "Unauthorized"
            );

            return;
        }

        System.out.println(
                "Authorization successful"
        );

        filterChain.doFilter(
                request,
                response
        );
    }
}