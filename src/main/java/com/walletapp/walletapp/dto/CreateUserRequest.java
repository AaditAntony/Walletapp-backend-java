package com.walletapp.walletapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateUserRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @PositiveOrZero(message = "Initial balance must be 0 or positive")
    private double balance;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}