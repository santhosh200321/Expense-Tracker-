package com.expensetracker.budgetservice.controller;

import com.expensetracker.budgetservice.model.Budget;
import com.expensetracker.budgetservice.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.createBudget(budget);
    }

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/user/{userId}")
    public List<Budget> getBudgetsByUserId(@PathVariable Long userId) {
        return budgetService.getBudgetsByUserId(userId);
    }

    @GetMapping("/{id}")
    public Budget getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

    @GetMapping("/{id}/canSpend/{amount}")
    public boolean canSpend(@PathVariable Long id, @PathVariable Double amount) {
        return budgetService.isTransactionAllowed(id, amount);
    }

    @PostMapping("/{id}/spend/{amount}")
    public void spend(@PathVariable Long id, @PathVariable Double amount) {
        budgetService.applyTransaction(id, amount);
    }
}
