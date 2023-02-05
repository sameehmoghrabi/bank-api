package dev.moghrabi.sameeh.bankapi.repository;

import dev.moghrabi.sameeh.bankapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
