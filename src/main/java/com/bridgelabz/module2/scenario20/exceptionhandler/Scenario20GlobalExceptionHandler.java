package com.bridgelabz.module2.scenario20.exceptionhandler;

import com.bridgelabz.module2.scenario20.exception.AccountNotFoundException;
import com.bridgelabz.module2.scenario20.exception.InsufficientBalanceException;
import com.bridgelabz.module2.scenario20.exception.TransferException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Scenario20GlobalExceptionHandler {

    /*
     * Account does not exist
     */

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
    handleAccountNotFound(
            AccountNotFoundException exception) {

        return buildResponse(
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );
    }

    /*
     * Insufficient balance
     */

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, Object>>
    handleInsufficientBalance(
            InsufficientBalanceException exception) {

        return buildResponse(
                HttpStatus.BAD_REQUEST,
                exception.getMessage()
        );
    }

    /*
     * Transfer exception
     */

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<Map<String, Object>>
    handleTransferException(
            TransferException exception) {

        return buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );
    }

    /*
     * DTO validation failure
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>>
    handleValidationException(
            MethodArgumentNotValidException exception) {

        Map<String, Object> errors =
                new HashMap<>();

        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        Map<String, Object> response =
                new HashMap<>();

        response.put("status", 400);
        response.put("message", "Validation failed");
        response.put("errors", errors);

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    /*
     * Generic exception
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>>
    handleGenericException(
            Exception exception) {

        return buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error"
        );
    }

    private ResponseEntity<Map<String, Object>>
    buildResponse(
            HttpStatus status,
            String message) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "status",
                status.value()
        );

        response.put(
                "message",
                message
        );

        return ResponseEntity
                .status(status)
                .body(response);
    }
}