package com.expensetracker.analysis.feign;

import com.expensetracker.analysis.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "transaction-service")
public interface TransactionClient {

    @GetMapping("/transactions/user/{userId}")
    List<TransactionDTO> getTransactionsByUserId(@PathVariable("userId") Long userId);
}