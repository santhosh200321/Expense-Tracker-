package com.expensetracker.budgetservice.service;

import com.expensetracker.budgetservice.client.UserClient;
import com.expensetracker.budgetservice.model.Budget;
import com.expensetracker.budgetservice.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final UserClient userClient;

    public Budget createBudget(Budget budget) {
        userClient.getUserById(budget.getUserId());
        budget.setUsedAmount(0.0);
        budget.setStartDate(LocalDate.now());
        budget.setEndDate(LocalDate.now().plusDays(30));
        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public List<Budget> getBudgetsByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    public Budget updateBudget(Long id, Budget updatedBudget) {
        return budgetRepository.findById(id).map(b -> {
            b.setTotalAmount(updatedBudget.getTotalAmount());
            b.setCategory(updatedBudget.getCategory());
            return budgetRepository.save(b);
        }).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public boolean isTransactionAllowed(Long budgetId, Double amount) {
        Budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        return (budget.getUsedAmount() + amount) <= budget.getTotalAmount();
    }

    public void applyTransaction(Long budgetId, Double amount) {
        budgetRepository.findById(budgetId).ifPresent(budget -> {
            budget.setUsedAmount(budget.getUsedAmount() + amount);
            budgetRepository.save(budget);
        });
    }
}
