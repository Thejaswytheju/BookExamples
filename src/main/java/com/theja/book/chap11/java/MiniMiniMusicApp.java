package com.theja.book.chap11.java;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

    public MiniMiniMusicApp() {
    }

    public void play() {

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence seq = new Sequence(0.0F, 4);
            Track track = seq.createTrack();
            MidiEvent event = null;

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1L);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16L);
            track.add(noteOff);

            sequencer.setSequence(seq);
            sequencer.start();
            Thread.sleep(1000L);
            sequencer.close();
            System.exit(0);
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

}
