package com.theja.book.chap7.java;

public class TestBoat {

    public TestBoat() {
    }

        public static void main(String args[]){
            Boat b1 = new Boat();
            SailBoat b2 = new SailBoat();
            RowBoat b3 = new RowBoat();
            b2.getlength(32);
            b1.move();
            b2.move();
            b3.move();
    }
    }


