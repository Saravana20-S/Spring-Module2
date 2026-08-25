package com.bridgelabz.module2.repository;

import com.bridgelabz.module2.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
        extends JpaRepository<Order, Long> {
}