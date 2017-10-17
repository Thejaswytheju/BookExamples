package com.theja.book.java;


public class DrumKitTest {
    public static void main(String args[]) {

        DrumKit d = new DrumKit();
        d.playSnare();
        d.snare = false;
        d.playTopHat();

        if(d.snare==true){
            d.playSnare();
        }
    }

}