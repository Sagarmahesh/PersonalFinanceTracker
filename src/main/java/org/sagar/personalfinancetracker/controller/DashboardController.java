package org.sagar.personalfinancetracker.controller;

import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.service.BudgetService;
import org.sagar.personalfinancetracker.service.TransactionService;
import org.sagar.personalfinancetracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {

    private BudgetService budgetService;
    private UserService userService;
    private TransactionService transactionService;

    public DashboardController(BudgetService budgetService, UserService userService, TransactionService transactionService) {
        this.budgetService = budgetService;
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @GetMapping(path = "/dashboard")
    public String dashboard(ModelMap model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("username", username);
        model.addAttribute("budgets", budgetService.getAllActiveBudgetsByUser(user));
        model.addAttribute("transactions", transactionService.getRecentTenTransactions(user));
        return "dashboard";
    }

}
