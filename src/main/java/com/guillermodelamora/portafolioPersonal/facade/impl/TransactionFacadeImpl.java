package com.guillermodelamora.portafolioPersonal.facade.impl;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.facade.TransactionFacade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionFacadeImpl implements TransactionFacade {
    @Override
    public List<Transaction> getAccountTransaction(Long accountId) {
        return List.of();
    }

    @Override
    public List<Transaction> getAccountCreditTransaction(Long accountId) {
        return List.of();
    }

    @Override
    public List<Transaction> getAccountDebitTransaction(Long accountId) {
        return List.of();
    }

    @Override
    public List<Transaction> getAccountTransactionsAmongTwoDates(Long accountId, Date initDate, Date endDate) {
        return List.of();
    }

    @Override
    public List<Transaction> getAccountTransactionsOverAnAmount(Long accountId, BigDecimal amount) {
        return List.of();
    }

    @Override
    public List<Transaction> getAccountTransactionsUnderAnAmount(Long accountId, BigDecimal amount) {
        return List.of();
    }
}
