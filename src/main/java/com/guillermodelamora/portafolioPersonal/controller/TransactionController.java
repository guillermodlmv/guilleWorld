package com.guillermodelamora.portafolioPersonal.controller;

import com.guillermodelamora.portafolioPersonal.entity.Transaction;
import com.guillermodelamora.portafolioPersonal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Crear una nueva transacción.
     */
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    /**
     * Obtener transacciones por cuenta.
     */
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByAccount(accountId);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Obtener transacciones por cuenta y rango de fechas.
     */
    @GetMapping("/account/{accountId}/date-range")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountAndDateRange(
            @PathVariable Long accountId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountAndDateRange(accountId, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Obtener transacciones por cuenta y monto mayor a un valor dado.
     */
    @GetMapping("/account/{accountId}/amount-greater-than")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountAndAmountGreaterThan(
            @PathVariable Long accountId,
            @RequestParam BigDecimal amount) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountAndAmountGreaterThan(accountId, amount);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Obtener transacciones por cuenta y tipo.
     */
    @GetMapping("/account/{accountId}/type")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountAndType(
            @PathVariable Long accountId,
            @RequestParam String type) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountAndType(accountId, type);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Eliminar transacciones por cuenta.
     */
    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<Void> deleteTransactionsByAccount(@PathVariable Long accountId) {
        transactionService.deleteTransactionsByAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar transacciones con monto menor a un valor dado.
     */
    @DeleteMapping("/amount-less-than")
    public ResponseEntity<Void> deleteTransactionsWithAmountLessThan(@RequestParam BigDecimal amount) {
        transactionService.deleteTransactionsWithAmountLessThan(amount);
        return ResponseEntity.noContent().build();
    }

    /**
     * Contar transacciones por cuenta.
     */
    @GetMapping("/account/{accountId}/count")
    public ResponseEntity<Long> countTransactionsByAccount(@PathVariable Long accountId) {
        Long count = transactionService.countTransactionsByAccount(accountId);
        return ResponseEntity.ok(count);
    }

    /**
     * Obtener transacciones por tipo y rango de fechas.
     */
    @GetMapping("/type/{type}/date-range")
    public ResponseEntity<List<Transaction>> getTransactionsByTypeAndDateRange(
            @PathVariable String type,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Transaction> transactions = transactionService.getTransactionsByTypeAndDateRange(type, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }
}
