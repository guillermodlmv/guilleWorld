package com.guillermodelamora.portafolioPersonal.repository;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Buscar una cuenta por usuario
    Optional<Account> findByUser(User user);

    // Buscar cuentas con un balance mayor a un valor específico
    List<Account> findByBalanceGreaterThan(BigDecimal balance);

    // Actualizar el saldo de la cuenta
    @Modifying
    @Query("UPDATE Account a SET a.balance = :balance WHERE a.id = :accountId")
    void updateBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);

    // Obtener todas las transacciones de una cuenta
    List<Transaction> findByAccount(Account account);

    // Contar las transacciones de una cuenta
    Long countByAccount(Account account);

    // Eliminar transacciones de una cuenta
    void deleteByAccount(Account account);

    // Buscar cuentas con un balance específico
    List<Account> findByBalance(BigDecimal balance);

    // Buscar transacciones de una cuenta en un rango de fechas
    List<Transaction> findByAccountAndDateBetween(Account account, LocalDate startDate, LocalDate endDate);

    // Buscar transacciones de una cuenta cuyo monto sea mayor que un valor específico
    List<Transaction> findByAccountAndAmountGreaterThan(Account account, BigDecimal amount);

}
