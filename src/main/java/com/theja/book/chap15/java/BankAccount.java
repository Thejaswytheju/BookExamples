package com.theja.book.chap15.java;

public class BankAccount {
    private int balance = 100;

    BankAccount() {
    }

    public int getBalance() {
        return this.balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }


}

