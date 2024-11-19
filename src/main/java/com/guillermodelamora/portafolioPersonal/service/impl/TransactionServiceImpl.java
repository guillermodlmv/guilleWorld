package com.guillermodelamora.portafolioPersonal.service.impl;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.repository.TransactionRepository;
import com.guillermodelamora.portafolioPersonal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByAccountIdAndTimestampBetween(accountId, startDate, endDate);
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndAmountGreaterThan(Long accountId, BigDecimal amount) {
        return transactionRepository.findByAccountIdAndAmountGreaterThan(accountId, amount);
    }

    @Override
    public List<Transaction> getTransactionsByAccountAndType(Long accountId, String type) {
        return transactionRepository.findByAccountIdAndType(accountId, type);
    }

    @Override
    public void deleteTransactionsByAccount(Long accountId) {
        transactionRepository.deleteByAccountId(accountId);
    }

    @Override
    public void deleteTransactionsWithAmountLessThan(BigDecimal amount) {
        transactionRepository.deleteByAmountLessThan(amount);
    }

    @Override
    public Long countTransactionsByAccount(Long accountId) {
        return transactionRepository.countByAccountId(accountId);
    }

    @Override
    public List<Transaction> getTransactionsByTypeAndDateRange(String type, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByTypeAndTimestampBetween(type, startDate, endDate);
    }
}
