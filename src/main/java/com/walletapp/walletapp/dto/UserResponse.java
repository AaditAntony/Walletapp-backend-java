package com.walletapp.walletapp.dto;



public class UserResponse {
    private Long id;
    private String name;
    private double balance;

    public UserResponse(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
}

