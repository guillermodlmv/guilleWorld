package com.guillermodelamora.portafolioPersonal.service;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    // Crear una nueva transacción
    Transaction createTransaction(Transaction transaction);

    // Buscar transacciones por cuenta
    List<Transaction> getTransactionsByAccount(Long accountId);

    // Buscar transacciones de una cuenta entre un rango de fechas
    List<Transaction> getTransactionsByAccountAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate);

    // Buscar transacciones de una cuenta cuyo monto sea mayor que un valor específico
    List<Transaction> getTransactionsByAccountAndAmountGreaterThan(Long accountId, BigDecimal amount);

    // Obtener todas las transacciones de tipo "CREDIT" o "DEBIT"
    List<Transaction> getTransactionsByAccountAndType(Long accountId, String type);

    // Eliminar transacciones de una cuenta
    void deleteTransactionsByAccount(Long accountId);

    // Eliminar transacciones con monto menor a un valor específico
    void deleteTransactionsWithAmountLessThan(BigDecimal amount);

    // Contar las transacciones de una cuenta
    Long countTransactionsByAccount(Long accountId);

    // Obtener transacciones por tipo y rango de fechas
    List<Transaction> getTransactionsByTypeAndDateRange(String type, LocalDateTime startDate, LocalDateTime endDate);
}
