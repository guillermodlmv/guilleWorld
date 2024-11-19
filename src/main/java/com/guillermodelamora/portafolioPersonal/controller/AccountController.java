package com.guillermodelamora.portafolioPersonal.controller;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Crear una nueva cuenta.
     */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    /**
     * Obtener una cuenta por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Obtener una cuenta por el ID del usuario.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Account> getAccountByUserId(@PathVariable Long userId) {
        return accountService.getAccountByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Obtener cuentas con saldo mayor que un valor específico.
     */
    @GetMapping("/balance/{balance}")
    public ResponseEntity<List<Account>> getAccountsByBalanceGreaterThan(@PathVariable BigDecimal balance) {
        List<Account> accounts = accountService.getAccountsByBalanceGreaterThan(balance);
        return ResponseEntity.ok(accounts);
    }

    /**
     * Actualizar el saldo de una cuenta.
     */
    @PutMapping("/{id}/balance")
    public ResponseEntity<Void> updateBalance(@PathVariable Long id, @RequestBody BigDecimal balance) {
        try {
            accountService.updateBalance(id, balance);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Obtener transacciones asociadas a una cuenta.
     */
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable Long id) {
        List<Transaction> transactions = accountService.getTransactionsByAccount(id);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Contar transacciones asociadas a una cuenta.
     */
    @GetMapping("/{id}/transactions/count")
    public ResponseEntity<Long> countTransactionsByAccount(@PathVariable Long id) {
        Long count = accountService.countTransactionsByAccount(id);
        return ResponseEntity.ok(count);
    }

    /**
     * Eliminar transacciones asociadas a una cuenta.
     */
    @DeleteMapping("/{id}/transactions")
    public ResponseEntity<Void> deleteTransactionsByAccount(@PathVariable Long id) {
        accountService.deleteTransactionsByAccount(id);
        return ResponseEntity.noContent().build();
    }
}
