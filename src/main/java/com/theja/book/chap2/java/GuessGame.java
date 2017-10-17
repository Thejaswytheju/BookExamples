package com.theja.book.chap2.java;

public class GuessGame{

        Player p1;
        Player p2;
        Player p3;

        public GuessGame() {
        }

        public void startGame() {
            this.p1 = new Player();
            this.p2 = new Player();
            this.p3 = new Player();
            boolean p1 = false;
            boolean p2 = false;
            boolean p3 = false;
            boolean p1isRight = false;
            boolean p2isRight = false;
            boolean p3isRight = false;
            int targetNumber = (int)(Math.random() * 10.0D);
            System.out.println("I'm thinking of a number between 0 and 9...");

            while(true) {
                System.out.println("Number to guess is " + targetNumber);
                this.p1.guess();
                this.p2.guess();
                this.p3.guess();
                int guessp1 = this.p1.number;
                System.out.println("Player one guessed " + guessp1);
                int guessp2 = this.p2.number;
                System.out.println("Player two guessed " + guessp2);
                int guessp3 = this.p3.number;
                System.out.println("Player three guessed " + guessp3);
                if (guessp1 == targetNumber) {
                    p1isRight = true;
                }

                if (guessp2 == targetNumber) {
                    p2isRight = true;
                }

                if (guessp3 == targetNumber) {
                    p3isRight = true;
                }

                if (p1isRight || p2isRight || p3isRight) {
                    System.out.println("We have a winner!");
                    System.out.println("Player one got it right? " + p1isRight);
                    System.out.println("Player two got it right? " + p2isRight);
                    System.out.println("Player three got it right? " + p3isRight);
                    System.out.println("Game is over");
                    return;
                }

                System.out.println("Players will have to try again.");
            }
        }

    }
