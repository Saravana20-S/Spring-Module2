package com.bridgelabz.module2.controller;

import com.bridgelabz.module2.dto.OrderRequestDTO;
import com.bridgelabz.module2.dto.OrderResponseDTO;
import com.bridgelabz.module2.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(
            @RequestBody OrderRequestDTO request) {

        System.out.println(
                "===== ORDER CONTROLLER ====="
        );

        OrderResponseDTO response =
                orderService.createOrder(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}