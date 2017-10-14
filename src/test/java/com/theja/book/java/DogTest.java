package com.theja.book.java;
public class DogTest {

    private static Dog Dog1;

    public static void main(String args[]) {
        Dog dog1 = new Dog();
        dog1.bark();
        //Dog1.name = "bart";
        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;
        myDogs[0].name = "fred";
        myDogs[1].name = "bruno";

        System.out.println("last dog name is:");
        System.out.println(myDogs[2].name);


        int x = 0;
        while (x < 2) {
            myDogs[x].bark();
            x = x + 1;
            System.out.println(myDogs[x] + "says Ruff!");

        }


    }
}