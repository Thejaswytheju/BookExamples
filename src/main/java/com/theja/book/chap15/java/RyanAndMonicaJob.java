package com.theja.book.chap15.java;

public class RyanAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();

    public RyanAndMonicaJob() {
    }

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for(int x = 0; x < 10; ++x) {
            this.makeWithdrawal(10);
            if (this.account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }

    }

    private synchronized void makeWithdrawal(int amount) {
        if (this.account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdrawal");

            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500L);
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " woke up");
            this.account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }

    }
}


