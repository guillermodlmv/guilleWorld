package com.guillermodelamora.portafolioPersonal.service;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    // Crear una nueva cuenta
    Account createAccount(Account account);

    // Buscar cuenta por ID
    Optional<Account> getAccountById(Long id);

    // Buscar cuenta por usuario
    Optional<Account> getAccountByUserId(Long userId);

    // Obtener todas las cuentas con balance mayor a un valor
    List<Account> getAccountsByBalanceGreaterThan(BigDecimal balance);

    // Actualizar balance de una cuenta
    void updateBalance(Long accountId, BigDecimal balance);

    // Obtener todas las transacciones de una cuenta
    List<Transaction> getTransactionsByAccount(Long accountId);

    // Contar las transacciones de una cuenta
    Long countTransactionsByAccount(Long accountId);

    // Eliminar transacciones de una cuenta
    void deleteTransactionsByAccount(Long accountId);
}
