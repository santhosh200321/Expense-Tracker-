package com.expensetracker.analysis.service;

import com.expensetracker.analysis.dto.TransactionDTO;
import com.expensetracker.analysis.feign.TransactionClient;
import com.expensetracker.analysis.model.AnalysisResult;
import com.expensetracker.analysis.repository.AnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisService {

    private final TransactionClient transactionClient;
    private final AnalysisRepository analysisRepository;

    public AnalysisService(TransactionClient transactionClient, AnalysisRepository analysisRepository) {
        this.transactionClient = transactionClient;
        this.analysisRepository = analysisRepository;
    }

    public AnalysisResult analyzeUserExpenses(Long userId) {
        List<TransactionDTO> transactions = transactionClient.getTransactionsByUserId(userId);

        double totalSpent = transactions.stream().mapToDouble(TransactionDTO::getAmount).sum();

        String mostFrequentCategory = transactions.stream()
                .collect(Collectors.groupingBy(TransactionDTO::getCategory, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        AnalysisResult result = analysisRepository.findByUserId(userId);
        if (result == null) {
            result = new AnalysisResult();
        }

        result.setUserId(userId);
        result.setTotalSpent(totalSpent);
        result.setMostFrequentCategory(mostFrequentCategory);

        return analysisRepository.save(result);
    }

    public AnalysisResult getAnalysis(Long userId) {
        return analysisRepository.findByUserId(userId);
    }
}