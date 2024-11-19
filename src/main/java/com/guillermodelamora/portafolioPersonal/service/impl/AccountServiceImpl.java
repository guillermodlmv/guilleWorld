package com.guillermodelamora.portafolioPersonal.service.impl;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.repository.AccountRepository;
import com.guillermodelamora.portafolioPersonal.repository.TransactionRepository;
import com.guillermodelamora.portafolioPersonal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public List<Account> getAccountsByBalanceGreaterThan(BigDecimal balance) {
        return accountRepository.findByBalanceGreaterThan(balance);
    }

    @Override
    public void updateBalance(Long accountId, BigDecimal balance) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            Account updatedAccount = account.get();
            updatedAccount.setBalance(balance);
            accountRepository.save(updatedAccount);
        } else {
            throw new IllegalArgumentException("Account with id " + accountId + " not found.");
        }
    }

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public Long countTransactionsByAccount(Long accountId) {
        return transactionRepository.countByAccountId(accountId);
    }

    @Override
    public void deleteTransactionsByAccount(Long accountId) {
        transactionRepository.deleteByAccountId(accountId);
    }
}
