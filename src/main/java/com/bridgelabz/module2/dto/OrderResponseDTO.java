package com.bridgelabz.module2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private Double totalAmount;

    private String message;
}