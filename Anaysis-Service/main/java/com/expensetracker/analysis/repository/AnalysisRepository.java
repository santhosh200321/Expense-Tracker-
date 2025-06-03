package com.expensetracker.analysis.repository;

import com.expensetracker.analysis.model.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<AnalysisResult, Long> {
    AnalysisResult findByUserId(Long userId);
}