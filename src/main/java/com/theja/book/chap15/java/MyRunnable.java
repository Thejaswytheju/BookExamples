package com.theja.book.chap15.java;

public class MyRunnable implements Runnable {
    public MyRunnable() {
    }

    public void run() {
        this.go();
    }

    public void go() {
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        this.doMore();
    }

    public void doMore() {
        System.out.println("top o' the stack");
    }

    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        System.out.println("back in main");
    }
}
