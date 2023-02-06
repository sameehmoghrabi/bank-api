package dev.moghrabi.sameeh.bankapp.service;

import dev.moghrabi.sameeh.bankapp.dto.CreateAccountDto;
import dev.moghrabi.sameeh.bankapp.model.Account;
import dev.moghrabi.sameeh.bankapp.model.Customer;
import dev.moghrabi.sameeh.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;

    public Account createAccount(CreateAccountDto accountDto) {
        Customer customer = customerService.getCustomerById(accountDto.getCustomerId());
        Double initialCredit = accountDto.getInitialCredit();

        /*It could have been done this way for creating a new account since its balance will always be zero at the beginning,
        but it is required to make Accounts and Transactions different services for a bonus.
        TransactionService.createTransaction is modified to update the balance of the associated account automatically based on transactions,
        so if you uncomment the following code to try it, it will add the initial balance twice to the associated account.*/
//        Account createdAccount = new Account(initialCredit, customer);
//        if(initialCredit > 0){
//            Transaction transaction = new Transaction(initialCredit, createdAccount);
//            createdAccount.getTransactions().add(transaction);
//        }
//
//        return accountRepository.save(createdAccount);

        Account createdAccount = accountRepository.save(new Account(customer));
        if (initialCredit > 0) {
            transactionService.createTransaction(initialCredit, createdAccount);
            //Test if adding another transaction to the same account will update its balance (for curiosity :D) --> success
            //transactionService.createTransaction(1000D, createdAccount);
        }

        return createdAccount;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
