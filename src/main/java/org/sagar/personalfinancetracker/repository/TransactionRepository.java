package org.sagar.personalfinancetracker.repository;

import org.sagar.personalfinancetracker.model.Transaction;
import org.sagar.personalfinancetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
    void delete(Transaction Transaction);
}
