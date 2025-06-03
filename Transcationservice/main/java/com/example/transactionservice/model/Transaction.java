package com.example.transactionservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long budgetId;
    private Double amount;
    private String category;
    private String description;
    private LocalDate date;

    // Getters and Setters
}
