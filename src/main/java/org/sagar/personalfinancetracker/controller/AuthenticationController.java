package org.sagar.personalfinancetracker.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.sagar.personalfinancetracker.model.User;
import org.sagar.personalfinancetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(ModelMap model, @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "register";
        }

        if(userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("usernameError", "User already exists");
            return "register";
        }

        userService.save(user);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {

        model.addAttribute("user", new User());
        return "login";
    }

}