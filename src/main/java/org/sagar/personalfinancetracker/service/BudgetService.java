package org.sagar.personalfinancetracker.service;

import org.sagar.personalfinancetracker.model.Budget;
import org.sagar.personalfinancetracker.model.Transaction;
import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.repository.BudgetRepository;
import org.sagar.personalfinancetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private BudgetRepository budgetRepository;
    private TransactionRepository transactionRepository;

    // Autowires the Dependencies.
    public BudgetService(BudgetRepository budgetRepository, TransactionRepository transactionRepository) {
        this.budgetRepository = budgetRepository;
        this.transactionRepository = transactionRepository;
    }

    // Returns all budgets belong to a specific user.
    public List<Budget> getBudgetsByUser(User user) {
        return budgetRepository.findByUser(user);
    }

    // Return a budget by its id.
    public Budget getBudgetById(long id) {
        Budget budget = budgetRepository.findById(id).orElse(null);
        return budget;
    }

    // Gets the amount remaning in the budget.
    public double getRemainingAmountForBudget(Budget budget) {
        List<Transaction> transactions = transactionRepository.findByUser(budget.getUser());
        double amount = 0;
        for(Transaction transaction : transactions) {
            if(transaction.getType().equals("Income")) continue;
            boolean condition = transaction.getDate().isAfter(budget.getFromDate().minusDays(1));
            condition = condition && transaction.getDate().isBefore(budget.getToDate().plusDays(1));
            if(condition) {
                amount = amount + transaction.getAmount();
            }
        }
        return budget.getAmount() - amount;
    }

    // Add new budget.
    public void addBudget(Budget budget) {
        double amount = getRemainingAmountForBudget(budget);
        budget.setRemainingAmount(amount);
        budgetRepository.save(budget);
    }

    // update budget.
    public void updateBudget(Budget budget) {
        double amount = getRemainingAmountForBudget(budget);
        budget.setRemainingAmount(amount);
        budgetRepository.save(budget);
    }

    // Add or Delete a Transaction from the budgets.
    public void updateBudgetFromTransaction(Transaction transaction, Boolean isAdd) {
        if(transaction.getType().equals("Income")) return;
        List<Budget> budgets = getBudgetsByUser(transaction.getUser());
        for(Budget budget : budgets) {
            boolean condition = transaction.getDate().isAfter(budget.getFromDate().minusDays(1));
            condition = condition && transaction.getDate().isBefore(budget.getToDate().plusDays(1));
            if(condition) {
                if(isAdd) {
                    budget.setRemainingAmount(budget.getRemainingAmount() - transaction.getAmount());
                    budgetRepository.save(budget);
                }
                else{
                    budget.setRemainingAmount(budget.getRemainingAmount() + transaction.getAmount());
                    budgetRepository.save(budget);
                }
            }
        }
    }

    // Update Transaction Amount in the Budget.
    public void updateBudgetFromTransaction(Transaction transaction, double amount){
        if(transaction.getType().equals("Income")) return;
        List<Budget> budgets = getBudgetsByUser(transaction.getUser());
        for(Budget budget : budgets) {
            boolean condition = transaction.getDate().isAfter(budget.getFromDate().minusDays(1));
            condition = condition && transaction.getDate().isBefore(budget.getToDate().plusDays(1));
            if(condition) {
                double netAmount = amount - transaction.getAmount();
                budget.setRemainingAmount(budget.getRemainingAmount() + netAmount);
            }
        }
    }

    // Add Transaction to the Budget.
    public void addTransactionToBudget(Transaction transaction) {
        updateBudgetFromTransaction(transaction, true);
    }

    // Delete Transaction form the Budget.
    public void deleteTransactionFromBudget(Transaction transaction) {
        updateBudgetFromTransaction(transaction, false);
    }

    // Delete a Budget.
    public void deleteBudget(Budget budget) {
        budgetRepository.delete(budget);
    }


    public List<Budget> getAllActiveBudgetsByUser(User user) {
        return budgetRepository.findByUser(user);
    }


}