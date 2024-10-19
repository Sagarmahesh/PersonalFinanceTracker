package org.sagar.personalfinancetracker.service;

import org.sagar.personalfinancetracker.model.Transaction;
import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    private BudgetService budgetService;

    // Autowires the Dependencies.
    public TransactionService(TransactionRepository transactionRepository, BudgetService budgetService) {
        this.budgetService = budgetService;
        this.transactionRepository = transactionRepository;
    }

    // return all transaction belong to specific user.
    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    // return a transaction by id.
    public Transaction getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        return transaction;
    }

    // Add a new Transaction.
    public void addTransaction(Transaction transaction) {
        budgetService.addTransactionToBudget(transaction);
        transactionRepository.save(transaction);
    }

    // Update a Transaction
    public void updateTransaction(Transaction transaction) {
        Transaction transactionToUpdate = transactionRepository.findById(transaction.getId()).orElse(null);
        double amount = 0;
        if(transactionToUpdate != null) {
            amount = transactionToUpdate.getAmount();
        }
        if(transaction.getAmount() != amount){
            budgetService.updateBudgetFromTransaction(transaction, amount);
        }
        transactionRepository.save(transaction);
    }

    // Delete a Transaction.
    public void deleteTransaction(Transaction transaction) {
        budgetService.deleteTransactionFromBudget(transaction);
        transactionRepository.delete(transaction);
    }

    // Get top 10 transactions.
    public List<Transaction> getRecentTenTransactions(User user) {
        List<Transaction> transactions = transactionRepository.findByUser(user);
        List<Transaction> recentTransactions = new ArrayList<>();
        for(Transaction transaction : transactions) {
            recentTransactions.add(transaction);
            if(recentTransactions.size() == 10) {
                break;
            }
        }
        return recentTransactions;
    }

}