package dev.moghrabi.sameeh.bankapi.service;

import dev.moghrabi.sameeh.bankapi.model.Account;
import dev.moghrabi.sameeh.bankapi.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    public Transaction createTransaction(Double amount, Account account);
}
