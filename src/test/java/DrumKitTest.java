package com.theja.book.java;


public class DrumKitTest {
    public static void main(String args[]) {

        DrumKit d = new DrumKit();
        d.PlaySnare();
        d.Snare = false;
        d.PlayTopHat();

        if(d.Snare==true){
            d.PlaySnare();
        }
    }

}