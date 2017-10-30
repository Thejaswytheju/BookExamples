package com.theja.book.chap16.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Jukebox6 {
    ArrayList<SongBad> songList = new ArrayList();

    public Jukebox6() {
    }
    private class SongBad implements Comparable<SongBad> {
        public SongBad(String token, String token1, String token2, String token3) {
        }

        public int compareTo(SongBad o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        (new Jukebox6()).go();
    }

    public void go() {
        this.getSongs();
        System.out.println(this.songList);
        Collections.sort(this.songList);
        System.out.println(this.songList);
        HashSet<SongBad> songSet = new HashSet();
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

    }


}
