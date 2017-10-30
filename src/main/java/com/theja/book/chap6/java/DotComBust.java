package com.theja.book.chap6.java;

import com.theja.book.chap5.java.GameHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList();
    private int numOfGuesses = 0;

    public DotComBust() {
    }

    public void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        this.dotComsList.add(one);
        this.dotComsList.add(two);
        this.dotComsList.add(three);
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        Iterator var5 = this.dotComsList.iterator();

        while(var5.hasNext()) {
            DotCom dotComSet = (DotCom)var5.next();
            ArrayList<String> newLocation = this.helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);
        }

    }

    public void startPlaying() {
        while(!this.dotComsList.isEmpty()) {
            String userGuess = this.helper.getUserInput("Enter a guess");
            this.checkUserGuess(userGuess);
        }

        this.finishGame();
    }

    private void checkUserGuess(String userGuess) {
        ++this.numOfGuesses;
        String result = "miss";
        Iterator var4 = this.dotComsList.iterator();

        while(var4.hasNext()) {
            DotCom dotComToTest = (DotCom)var4.next();
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }

            if (result.equals("kill")) {
                this.dotComsList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead!  Your stock is now worthless");
        if (this.numOfGuesses <= 18) {
            System.out.println("It only took you " + this.numOfGuesses + " guesses");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + this.numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }

    }

}




