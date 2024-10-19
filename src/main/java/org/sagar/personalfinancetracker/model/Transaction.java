package org.sagar.personalfinancetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @NotNull(message = "Transaction Type is Required")
    @Size(min=6, max = 7, message = "The type should be income or expense")
    private String type;

    @Column(nullable = false)
    @NotNull(message = "Category is Required")
    @Size(min=3, message = "The Category should be minimum 3 characters")
    private String category;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater then 0")
    private double amount;

    @Column(nullable = false)
    @NotNull(message = "Description is Required")
    @Size(min=3, message = "The Description should be minimum 3 characters")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Date is Required")
    private LocalDate date;


    public Transaction() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", id=" + id +
                ", user=" + user +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}