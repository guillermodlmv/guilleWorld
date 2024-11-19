package com.guillermodelamora.portafolioPersonal.repository;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Buscar transacciones de una cuenta
    List<Transaction> findByAccount(Account account);

    // Buscar transacciones de una cuenta
    List<Transaction> findByAccountId(Long accountId);

    // Buscar transacciones de una cuenta entre un rango de fechas
    List<Transaction> findByAccountAndTimestampBetween(Account account, LocalDateTime startDate, LocalDateTime endDate);

    // Buscar transacciones de una cuenta cuyo monto sea mayor que un valor específico
    List<Transaction> findByAccountAndAmountGreaterThan(Account account, BigDecimal amount);

    // Buscar todas las transacciones de tipo "CREDIT" o "DEBIT" en una cuenta
    List<Transaction> findByAccountAndType(Account account, String type);

    // Obtener las transacciones de una cuenta ordenadas por fecha descendente (más recientes primero)
    List<Transaction> findByAccountOrderByTimestampDesc(Account account);

    // Contar el número de transacciones de una cuenta
    Long countByAccount(Account account);

    // Contar el número de transacciones de una cuenta por su id
    Long countByAccountId(Long accountId);

    // Eliminar transacciones de una cuenta
    void deleteByAccount(Account account);

    // Eliminar transacciones de una cuenta por su id
    void deleteByAccountId(Long accountId);

    // Buscar transacciones cuyo monto sea mayor que un valor específico
    List<Transaction> findByAmountGreaterThan(BigDecimal amount);

    // Buscar transacciones por tipo y monto mayor a un valor específico
    List<Transaction> findByTypeAndAmountGreaterThan(String type, BigDecimal amount);

    // Eliminar transacciones que tengan un monto menor que un valor específico
    @Modifying
    @Query("DELETE FROM Transaction t WHERE t.amount < :amount")
    void deleteByAmountLessThan(@Param("amount") BigDecimal amount);

    // Buscar transacciones entre dos fechas
    List<Transaction> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Buscar transacciones cuyo tipo sea "CREDIT" o "DEBIT" entre dos fechas
    List<Transaction> findByTypeAndTimestampBetween(String type, LocalDateTime startDate, LocalDateTime endDate);

    // Crear una transacción (Método para crear transacciones específicas desde el repositorio si fuera necesario)
    // Este método generalmente se maneja desde el servicio, pero se puede agregar para facilitar la persistencia en algunos casos.
    @Modifying
    @Query("INSERT INTO Transaction (account, amount, type, timestamp, description) VALUES (:account, :amount, :type, :timestamp, :description)")
    void createTransaction(@Param("account") Account account,
                           @Param("amount") BigDecimal amount,
                           @Param("type") String type,
                           @Param("timestamp") LocalDateTime timestamp,
                           @Param("description") String description);

    // Buscar transacciones por ID de cuenta y rango de fechas
    List<Transaction> findByAccountIdAndTimestampBetween(Long accountId, LocalDateTime startDate, LocalDateTime endDate);

    // Buscar transacciones por ID de cuenta y monto mayor que un valor
    List<Transaction> findByAccountIdAndAmountGreaterThan(Long accountId, BigDecimal amount);

    // Buscar transacciones por ID de cuenta y tipo (CREDIT o DEBIT)
    List<Transaction> findByAccountIdAndType(Long accountId, String type);
}
