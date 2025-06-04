package com.gevernova.bankaccount;

public class BankAccount {
    private int balance = 1000; // initial balance

    // synchronized method to deposit
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance);
    }

    // synchronized method to withdraw
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds. Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}
