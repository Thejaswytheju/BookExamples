package com.theja.book.chap7.java;

public class Boat {

    private int length;
    Boat() {
    }
        public void setlength ( int length){
            this.length = length;
        }

    public int getlength(int i) {
        return this.length;
    }

    public void move() {
        System.out.println("drift");
    }
}

