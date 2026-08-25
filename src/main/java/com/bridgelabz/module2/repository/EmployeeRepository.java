package com.bridgelabz.module2.repository;

import com.bridgelabz.module2.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}