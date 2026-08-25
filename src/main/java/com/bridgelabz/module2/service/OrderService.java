package com.bridgelabz.module2.service;

import com.bridgelabz.module2.dto.OrderRequestDTO;
import com.bridgelabz.module2.dto.OrderResponseDTO;
import com.bridgelabz.module2.entity.Order;
import com.bridgelabz.module2.entity.Product;
import com.bridgelabz.module2.repository.OrderRepository;
import com.bridgelabz.module2.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(
            ProductRepository productRepository,
            OrderRepository orderRepository) {

        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderResponseDTO createOrder(
            OrderRequestDTO request) {

        System.out.println(
                "===== ORDER SERVICE ====="
        );

        // 1. Find product

        Product product =
                productRepository
                        .findById(request.getProductId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Product not found"
                                )
                        );

        // 2. Check quantity

        if (request.getQuantity() <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        // 3. Check stock

        if (product.getStock()
                < request.getQuantity()) {

            throw new RuntimeException(
                    "Insufficient stock"
            );
        }

        // 4. Calculate total

        double totalAmount =
                product.getPrice()
                        * request.getQuantity();

        // 5. Create Order Entity

        Order order = new Order();

        order.setProduct(product);

        order.setQuantity(
                request.getQuantity()
        );

        order.setTotalAmount(
                totalAmount
        );

        // 6. Update stock

        product.setStock(
                product.getStock()
                        - request.getQuantity()
        );

        productRepository.save(product);

        // 7. Save order

        Order savedOrder =
                orderRepository.save(order);

        // 8. Convert Entity → DTO

        return new OrderResponseDTO(
                savedOrder.getId(),
                product.getId(),
                savedOrder.getQuantity(),
                savedOrder.getTotalAmount(),
                "Order created successfully"
        );
    }
}