package com.theja.book.chap5.java;

public class SimpleDotComTest {

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = new int[]{2, 3, 4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        dot.checkYourself(userGuess);
    }
}











