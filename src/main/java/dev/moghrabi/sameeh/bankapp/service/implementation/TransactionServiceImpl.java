package dev.moghrabi.sameeh.bankapp.service.implementation;

import dev.moghrabi.sameeh.bankapp.model.Account;
import dev.moghrabi.sameeh.bankapp.model.Transaction;
import dev.moghrabi.sameeh.bankapp.repository.TransactionRepository;
import dev.moghrabi.sameeh.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Double amount, Account account) {
        // update the balance of the associated account
        account.setBalance(account.getBalance() + amount);
        return transactionRepository.save(new Transaction(amount, account));
    }
}
