package com.guillermodelamora.portafolioPersonal.repository;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    // Buscar cuentas con un balance específico
    List<Account> findByBalance(BigDecimal balance);

    Optional<Account> findByUserId(Long userId);

}
