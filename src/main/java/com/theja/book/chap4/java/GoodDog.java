package com.theja.book.chap4.java;

public class GoodDog {
    private int size;

    GoodDog() {
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int var1) {
        this.size = var1;
    }

    void bark() {
        if (this.size > 60) {
            System.out.println("Wooof! Wooof!");
        } else if (this.size > 60) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }

    }
}
