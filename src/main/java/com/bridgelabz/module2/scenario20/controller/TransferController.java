package com.bridgelabz.module2.scenario20.controller;

import com.bridgelabz.module2.scenario20.dto.TransferRequestDTO;
import com.bridgelabz.module2.scenario20.dto.TransferResponseDTO;
import com.bridgelabz.module2.scenario20.service.TransferService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(
            TransferService transferService) {

        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<TransferResponseDTO> transfer(
            @Valid
            @RequestBody TransferRequestDTO request) {

        System.out.println(
                "===== TRANSFER CONTROLLER ====="
        );

        TransferResponseDTO response =
                transferService.transfer(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}