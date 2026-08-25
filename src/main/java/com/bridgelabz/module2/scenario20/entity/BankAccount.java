package com.bridgelabz.module2.scenario20.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private BigDecimal balance;
}