package org.sagar.personalfinancetracker.controller;

import jakarta.validation.Valid;
import org.sagar.personalfinancetracker.model.Budget;
import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.service.BudgetService;
import org.sagar.personalfinancetracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BudgetController {

    private BudgetService budgetService;

    private UserService userService;

    public BudgetController(BudgetService budgetService, UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }

    @GetMapping(path = "/budgets")
    public String getBudgets(ModelMap model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Budget> budgets = budgetService.getBudgetsByUser(user);
        for(Budget budget : budgets) {
            if(budget.getToDate().isBefore(LocalDate.now())){
                budget.setStatus("Completed");
            }
        }
        model.addAttribute("budgets", budgets);
        return "budgets";
    }

    @GetMapping(path = "/budget")
    public String showBudgetPage(ModelMap model) {
        model.addAttribute("budget", new Budget());
        model.addAttribute("add_or_update", "Add");
        return "budget";
    }

    @PostMapping(path = "/budget")
    public String addBudget(ModelMap model, @Valid Budget budget, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "budget";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        budget.setUser(user);
        budgetService.addBudget(budget);
        return "redirect:/budgets";
    }

    @GetMapping(path = "/update-budget")
    public String showUpdateBudget(@RequestParam long id, ModelMap model, Principal principal) {
        Budget budget = budgetService.getBudgetById(id);
        model.addAttribute("budget", budget);
        model.addAttribute("add_or_update", "Update");
        return "budget";
    }

    @PostMapping(path = "update-budget")
    public String updateBudget(@Valid Budget budget, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "budget";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        budget.setUser(user);
        budgetService.updateBudget(budget);
        return "redirect:/budgets";
    }

    @GetMapping("delete-budget")
    public String deleteBudget(@RequestParam long id) {
        Budget budget = budgetService.getBudgetById(id);
        budgetService.deleteBudget(budget);
        return "redirect:/budgets";
    }

}