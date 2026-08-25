package com.bridgelabz.module2.exception;

public class JwtAuthenticationException
        extends RuntimeException {

    public JwtAuthenticationException(String message) {
        super(message);
    }
}