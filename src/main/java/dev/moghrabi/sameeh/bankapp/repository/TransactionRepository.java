package dev.moghrabi.sameeh.bankapp.repository;

import dev.moghrabi.sameeh.bankapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
