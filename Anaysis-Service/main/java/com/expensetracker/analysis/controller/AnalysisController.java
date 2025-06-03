package com.expensetracker.analysis.controller;

import com.expensetracker.analysis.model.AnalysisResult;
import com.expensetracker.analysis.service.AnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/generate/{userId}")
    public AnalysisResult generateAnalysis(@PathVariable Long userId) {
        return analysisService.analyzeUserExpenses(userId);
    }

    @GetMapping("/user/{userId}")
    public AnalysisResult getAnalysis(@PathVariable Long userId) {
        return analysisService.getAnalysis(userId);
    }
}