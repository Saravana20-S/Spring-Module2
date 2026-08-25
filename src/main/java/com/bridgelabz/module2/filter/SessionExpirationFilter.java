package com.bridgelabz.module2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SessionExpirationFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String uri =
                request.getRequestURI();

        /*
         * Only protect Scenario 9
         * account endpoint.
         */
        if (uri.equals(
                request.getContextPath()
                        + "/scenario9/accounts")) {

            HttpSession session =
                    request.getSession(false);

            if (session == null) {

                System.out.println(
                        "SESSION EXPIRED OR NOT FOUND"
                );

                response.setStatus(
                        HttpServletResponse
                                .SC_UNAUTHORIZED
                );

                response.getWriter().write(
                        "Session expired. Please login again."
                );

                return;
            }

            String username =
                    (String) session.getAttribute(
                            "USERNAME"
                    );

            if (username == null) {

                System.out.println(
                        "SESSION DATA NOT FOUND"
                );

                response.setStatus(
                        HttpServletResponse
                                .SC_UNAUTHORIZED
                );

                response.getWriter().write(
                        "Session expired. Please login again."
                );

                return;
            }
        }

        /*
         * Continue request.
         */
        filterChain.doFilter(
                request,
                response
        );
    }
}