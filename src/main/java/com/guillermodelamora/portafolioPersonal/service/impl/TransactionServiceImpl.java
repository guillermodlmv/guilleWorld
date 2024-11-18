package com.guillermodelamora.portafolioPersonal.service.impl;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndAmountGreaterThan(Long accountId, BigDecimal amount) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndType(Long accountId, String type) {
        return List.of();
    }

    @Override
    public void deleteTransactionsByAccount(Long accountId) {

    }

    @Override
    public void deleteTransactionsWithAmountLessThan(BigDecimal amount) {

    }

    @Override
    public Long countTransactionsByAccount(Long accountId) {
        return 0L;
    }

    @Override
    public List<Transaction> getTransactionsByTypeAndDateRange(String type, LocalDateTime startDate, LocalDateTime endDate) {
        return List.of();
    }
}
