package com.gevernova.bankaccount;

public class BankTransaction {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        // Create 2 threads simulating concurrent transactions
        Thread t1 = new Thread(new Transaction(account), "Thread-1");
        Thread t2 = new Thread(new Transaction(account), "Thread-2");

        t1.start();
        t2.start();

        t1.join(); // wait for t1 to finish
        t2.join(); // wait for t2 to finish

        System.out.println("Final Balance: " + account.getBalance());
    }
}
