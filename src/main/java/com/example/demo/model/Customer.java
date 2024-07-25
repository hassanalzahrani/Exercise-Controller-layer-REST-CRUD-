package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String userName;
    private int balance;
    private int amount;

    public void setDeposit(double deposit) {
        this.balance += deposit;
    }

    public double getDeposit() {
        return this.balance;
    }
}
