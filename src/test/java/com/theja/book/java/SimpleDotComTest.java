package com.theja.book.java;

public class SimpleDotComTest {

    private int[] locations;

    private String CheckYourself(String userguess) {
        return userguess;
    }

    public void setlocations(int[] locations) {

        this.locations = locations;
    }

    public static void main(String args[]){
        SimpleDotComTest Dot = new SimpleDotComTest();

        int[] locations = {2,3,4};

        Dot.setlocations(locations);

        String Userguess = "2";

        String result = Dot.CheckYourself(Userguess);

        String TestResults = "failed";

        if (result.equals("hit"));

        TestResults = "passed";

        System.out.println(TestResults);

    }


}
