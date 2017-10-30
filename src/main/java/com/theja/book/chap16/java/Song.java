package com.theja.book.chap16.java;

import java.util.Comparator;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;


    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public int compare(Song o1, Song o2) {
        return 0;
    }

    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {

        return title.hashCode();
    }

    public int compareTo(Song s)
    {
        if (title != null) {
            return title.compareTo(s.title);
        }
        if (artist != null) {
            return artist.compareTo(s.artist);
        }
        return 0;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getBpm()
    {
        return bpm;
    }

    public String getRating()
    {
        return rating;
    }

    public String getTitle()
    {
        return title;
    }

    public String toString() {
        return title;
    }

}


