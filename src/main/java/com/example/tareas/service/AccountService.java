package com.example.tareas.service;

import com.example.tareas.model.Account;
import com.example.tareas.model.Transaction;
import com.example.tareas.repository.AccountRepository;
import com.example.tareas.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    //Inyeccion de en constructor, mejor practica que el autowired.

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Transaction executeTransaction(Transaction transaction) {
        Account account = getAccount(transaction.getAccountId());

        if ("DEPOSIT".equalsIgnoreCase(transaction.getType())) {
            account.setBalance(account.getBalance() + transaction.getAmount());
        } else if ("WITHDRAWAL".equalsIgnoreCase(transaction.getType())) {
            if (account.getBalance() < transaction.getAmount()) {
                throw new RuntimeException("Insufficient funds");
            }
            account.setBalance(account.getBalance() - transaction.getAmount());
        }

        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }

}
