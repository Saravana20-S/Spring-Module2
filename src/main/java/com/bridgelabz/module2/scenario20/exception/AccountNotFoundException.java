package com.bridgelabz.module2.scenario20.exception;

public class AccountNotFoundException
        extends RuntimeException {

    public AccountNotFoundException(String accountNumber) {

        super(
                "Account not found: "
                        + accountNumber
        );
    }
}