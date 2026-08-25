package com.bridgelabz.module2.scenario20.service;

import com.bridgelabz.module2.scenario20.dto.TransferRequestDTO;
import com.bridgelabz.module2.scenario20.dto.TransferResponseDTO;
import com.bridgelabz.module2.scenario20.entity.BankAccount;
import com.bridgelabz.module2.scenario20.exception.AccountNotFoundException;
import com.bridgelabz.module2.scenario20.exception.InsufficientBalanceException;
import com.bridgelabz.module2.scenario20.exception.TransferException;
import com.bridgelabz.module2.scenario20.repository.BankAccountRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransferService {

    private final BankAccountRepository accountRepository;

    public TransferService(
            BankAccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }

    @Transactional
    public TransferResponseDTO transfer(
            TransferRequestDTO request) {

        System.out.println(
                "===== TRANSFER SERVICE STARTED ====="
        );

        /*
         * 1. Find source account
         */

        BankAccount fromAccount =
                accountRepository
                        .findById(request.getFromAccount())
                        .orElseThrow(() ->
                                new AccountNotFoundException(
                                        request.getFromAccount()
                                )
                        );

        /*
         * 2. Find destination account
         */

        BankAccount toAccount =
                accountRepository
                        .findById(request.getToAccount())
                        .orElseThrow(() ->
                                new AccountNotFoundException(
                                        request.getToAccount()
                                )
                        );

        /*
         * 3. Check balance
         */

        if (fromAccount.getBalance()
                .compareTo(request.getAmount()) < 0) {

            throw new InsufficientBalanceException();
        }

        /*
         * 4. Debit source account
         */

        fromAccount.setBalance(
                fromAccount.getBalance()
                        .subtract(request.getAmount())
        );

        accountRepository.save(fromAccount);

        System.out.println(
                "Amount debited from "
                        + request.getFromAccount()
        );

        /*
         * 5. Credit destination account
         */

        toAccount.setBalance(
                toAccount.getBalance()
                        .add(request.getAmount())
        );

        accountRepository.save(toAccount);

        System.out.println(
                "Amount credited to "
                        + request.getToAccount()
        );

        /*
         * 6. Return response
         */

        String transactionId =
                UUID.randomUUID().toString();

        System.out.println(
                "===== TRANSFER COMPLETED ====="
        );

        return new TransferResponseDTO(
                transactionId,
                request.getFromAccount(),
                request.getToAccount(),
                request.getAmount(),
                "SUCCESS",
                "Transfer completed successfully"
        );
    }
}