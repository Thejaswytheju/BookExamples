package com.theja.book.chap10.java;

import java.util.Calendar;

import static com.theja.book.chap10.java.FullMoons.DAY_IM;

public class FullMoonsTest {

    public static void main(String args[]){

        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);
        long day1 = c.getTimeInMillis();

        for(int x = 0; x < 20; ++x) {
            day1 = (long)((double)day1 + (double)DAY_IM * 29.52D);
            c.setTimeInMillis(day1);
            System.out.println(String.format("full moon on %tc", c));
        }
    }
}
