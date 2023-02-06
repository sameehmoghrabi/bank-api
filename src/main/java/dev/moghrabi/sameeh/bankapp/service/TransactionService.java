package dev.moghrabi.sameeh.bankapp.service;

import dev.moghrabi.sameeh.bankapp.model.Account;
import dev.moghrabi.sameeh.bankapp.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    public Transaction createTransaction(Double amount, Account account);
}
