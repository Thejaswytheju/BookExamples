package com.theja.book.chap16.java;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {
    public int compare(Song o1, Song o2) {
        if (o1.title != null) {
            return o1.title.compareTo(o2.title);
        }
        if (o1.artist != null) {
            return o1.artist.compareTo(o2.artist);
        }
        return 0;
    }

}
