package org.sagar.personalfinancetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is required")
    @Size(min = 5, max = 16, message = "Username must be between 5 and 16 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull(message = "Password is required")
    //@Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Email is required")
    @Size(min = 5, max = 25, message = "Email must be between 5 and 25 characters")
    @Column(unique = true, nullable = false)
    private String email;

    private String role = "USER";

    public User() {
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}