package com.example.transactionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "budget-service")
public interface BudgetClient {
    @GetMapping("/api/budgets/{id}")
    String getBudgetById(@PathVariable("id") Long id);
}
