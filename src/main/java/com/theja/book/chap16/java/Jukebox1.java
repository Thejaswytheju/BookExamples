package com.theja.book.chap16.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Jukebox1 {
    ArrayList<String> songList = new ArrayList();

    public Jukebox1() {
    }

    public static void main(String[] args) {

        (new Jukebox1()).go();
    }

    public void go() {
        this.getSongs();
        System.out.println(this.songList);
    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;

            while((line = reader.readLine()) != null) {
                this.addSong(line);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        this.songList.add(tokens[0]);
    }
}


