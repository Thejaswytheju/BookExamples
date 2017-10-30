package com.theja.book.java;

import com.sun.glass.ui.Size;

public class Duck {
    int size;
    public Duck(){
        System.out.println("Quack");
    }

    public void setSize(int size){
        this.size = size;
    }
    public static void main(String args[]){
        Duck d = new Duck();
        d.setSize(32);


    }
}
