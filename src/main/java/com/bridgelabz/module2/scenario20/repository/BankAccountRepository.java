package com.bridgelabz.module2.scenario20.repository;

import com.bridgelabz.module2.scenario20.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository
        extends JpaRepository<BankAccount, String> {

}