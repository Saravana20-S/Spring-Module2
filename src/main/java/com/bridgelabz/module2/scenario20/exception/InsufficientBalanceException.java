package com.bridgelabz.module2.scenario20.exception;

public class InsufficientBalanceException
        extends RuntimeException {

    public InsufficientBalanceException() {

        super("Insufficient balance");
    }
}