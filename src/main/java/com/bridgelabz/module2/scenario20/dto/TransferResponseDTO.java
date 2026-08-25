package com.bridgelabz.module2.scenario20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDTO {

    private String transactionId;

    private String fromAccount;

    private String toAccount;

    private BigDecimal amount;

    private String status;

    private String message;
}