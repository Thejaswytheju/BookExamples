package com.theja.book.chap16.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Jukebox8 {
    ArrayList<Song> songList = new ArrayList();

    public Jukebox8() {
    }

    public static void main(String[] args) {
        (new Jukebox8()).go();
    }

    public void go() {
        this.getSongs();
        System.out.println(this.songList);
        Collections.sort(this.songList);
        System.out.println(this.songList);
        TreeSet<Song> songSet = new TreeSet();
        songSet.addAll(this.songList);
        System.out.println(songSet);
    }

    void getSongs() {
        try {
            File file = new File("SongListMore.txt");
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
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        this.songList.add(nextSong);
    }
}
