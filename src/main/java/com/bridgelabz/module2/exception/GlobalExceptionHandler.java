package com.bridgelabz.module2.exception;

import com.bridgelabz.module2.dto.ErrorResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO>
    handleEmployeeNotFound(
            EmployeeNotFoundException exception) {

        System.out.println(
                "===== GLOBAL EXCEPTION HANDLER ====="
        );

        System.out.println(
                "Exception: "
                        + exception.getMessage()
        );

        ErrorResponseDTO error =
                new ErrorResponseDTO(
                        HttpStatus.NOT_FOUND.value(),
                        "NOT_FOUND",
                        exception.getMessage()
                );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}