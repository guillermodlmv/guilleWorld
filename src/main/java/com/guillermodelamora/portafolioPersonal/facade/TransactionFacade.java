package com.guillermodelamora.portafolioPersonal.facade;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionFacade {
    List<Transaction> getAccountTransaction(Long accountId);

    List<Transaction> getAccountCreditTransaction(Long accountId);

    List<Transaction> getAccountDebitTransaction(Long accountId);

    List<Transaction> getAccountTransactionsAmongTwoDates(Long accountId, Date initDate, Date endDate);

    List<Transaction> getAccountTransactionsOverAnAmount(Long accountId, BigDecimal amount);

    List<Transaction> getAccountTransactionsUnderAnAmount(Long accountId, BigDecimal amount);
}
