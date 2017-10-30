package com.theja.book.chap16.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox3 {
    ArrayList<Song> songList = new ArrayList();

    public Jukebox3() {
    }

    public static void main(String[] args) {
        (new Jukebox3()).go();
    }

    public void go() {
        this.getSongs();
        System.out.println(this.songList);
        Collections.sort(this.songList, new SongComparator());
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
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        this.songList.add(nextSong);
    }
}
