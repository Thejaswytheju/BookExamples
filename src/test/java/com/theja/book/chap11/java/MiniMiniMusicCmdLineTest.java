package com.theja.book.chap11.java;

public class MiniMiniMusicCmdLineTest {
    public static void main(String[] args) {
        MiniMiniMusicCmdLine mini = new MiniMiniMusicCmdLine();
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        }
        else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }
}