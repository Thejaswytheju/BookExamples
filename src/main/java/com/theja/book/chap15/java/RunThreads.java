package com.theja.book.chap15.java;

public class RunThreads implements Runnable {
    public RunThreads() {
    }

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("Alpha thread");
        beta.setName("Beta thread");
        alpha.start();
        beta.start();
    }

    public void run() {
        for(int i = 0; i < 5; ++i) {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is running");
        }

    }

}
