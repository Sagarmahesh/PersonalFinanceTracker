package org.sagar.personalfinancetracker.controller;

import jakarta.validation.Valid;
import org.sagar.personalfinancetracker.model.Transaction;
import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.service.TransactionService;
import org.sagar.personalfinancetracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class TransactionController {

    private TransactionService transactionService;

    private UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/transactions")
    public String transactions(ModelMap model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Transaction> transactions= transactionService.getTransactionsByUser(user);
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @GetMapping("/transaction")
    public String showTransactionPage(ModelMap model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        model.addAttribute("add_or_update", "Add");
        return "transaction";
    }

    @PostMapping("/transaction")
    public String addTransaction(ModelMap model, @Valid Transaction transaction, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            //model.addAttribute("transaction", transaction);
            return "transaction";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        transaction.setUser(user);
        transactionService.addTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping(path = "/update-transaction")
    public String updateTransaction(@RequestParam long id, ModelMap model, Principal principal) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("add_or_update", "Update");
        return "transaction";
    }

    @PostMapping(path = "update-transaction")
    public String updateTransaction(@Valid Transaction transaction, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "transaction";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        transaction.setUser(user);
        transactionService.updateTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("delete-transaction")
    public String deleteTransaction(@RequestParam long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        transactionService.deleteTransaction(transaction);
        return "redirect:/transactions";
    }

}