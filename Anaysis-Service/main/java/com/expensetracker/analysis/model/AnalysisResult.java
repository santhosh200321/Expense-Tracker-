package com.expensetracker.analysis.model;

import jakarta.persistence.*;

@Entity
public class AnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double totalSpent;
    private String mostFrequentCategory;

    // Getters and Setters
}