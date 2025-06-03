package com.expensetracker.analysis.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
    private Long id;
    private Long userId;
    private String category;
    private double amount;
    private LocalDateTime timestamp;

    // Getters and Setters
}