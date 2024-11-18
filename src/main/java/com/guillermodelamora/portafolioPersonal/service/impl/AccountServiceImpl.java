package com.guillermodelamora.portafolioPersonal.service.impl;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> getAccountByUserId(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAccountsByBalanceGreaterThan(BigDecimal balance) {
        return List.of();
    }

    @Override
    public void updateBalance(Long accountId, BigDecimal balance) {

    }

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return List.of();
    }

    @Override
    public Long countTransactionsByAccount(Long accountId) {
        return 0L;
    }

    @Override
    public void deleteTransactionsByAccount(Long accountId) {

    }
}
