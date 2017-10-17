package com.theja.book.java;

import java.sql.Time;

public class ClockTest {
    public static void main(String args[]){

        Clock c = new Clock();
        c.SetTime("1234");
        String tod = c.getTime();
        System.out.println("time:" +tod);
    }

}
