package com.example.brainridgeassessment.dto;

public class UserCreateDTO {
    private double balance;

    public UserCreateDTO() {}

    public UserCreateDTO(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
}
