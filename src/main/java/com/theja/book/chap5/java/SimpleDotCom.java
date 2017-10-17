package com.theja.book.chap5.java;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public SimpleDotCom() {
    }

    public void setLocationCells(int[] locs) {

        this.locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        int[] var7 = this.locationCells;
        int var5 = 0;

        for(int var6 = var7.length; var5 < var6; ++var5) {
            int cell = var7[var5];
            if (guess == cell) {
                result = "hit";
                ++this.numOfHits;
                break;
            }
        }

        if (this.numOfHits == this.locationCells.length) {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}
