package com.bridgelabz.module2.service;

import com.bridgelabz.module2.dto.EmployeeRequestDTO;
import com.bridgelabz.module2.entity.Employee;
import com.bridgelabz.module2.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeRequestService {

    private final EmployeeRepository employeeRepository;

    public EmployeeRequestService(
            EmployeeRepository employeeRepository) {

        this.employeeRepository =
                employeeRepository;
    }

    public Employee createEmployee(
            EmployeeRequestDTO requestDTO) {

        System.out.println(
                "===== SERVICE ====="
        );

        System.out.println(
                "DTO received"
        );

        System.out.println(
                "Name: "
                        + requestDTO.getName()
        );

        System.out.println(
                "Email: "
                        + requestDTO.getEmail()
        );

        /*
         * DTO → Entity
         */
        Employee employee =
                new Employee();

        employee.setName(
                requestDTO.getName()
        );

        employee.setEmail(
                requestDTO.getEmail()
        );

        System.out.println(
                "DTO converted to Employee Entity"
        );

        /*
         * Entity → Repository → JPA
         */
        return employeeRepository.save(
                employee
        );
    }
}