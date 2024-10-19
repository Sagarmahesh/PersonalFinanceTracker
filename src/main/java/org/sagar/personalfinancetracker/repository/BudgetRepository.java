package org.sagar.personalfinancetracker.repository;

import org.sagar.personalfinancetracker.model.Budget;
import org.sagar.personalfinancetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUser(User user);
}
