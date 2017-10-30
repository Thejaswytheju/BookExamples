package com.theja.book.chap11.java;

import javax.sound.midi.*;

public class MiniMiniMusicCmdLine {

    public MiniMiniMusicCmdLine() {
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(0.0F, 4);
            Track track = seq.createTrack();
            MidiEvent event = null;
            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1L);
            track.add(changeInstrument);
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1L);
            track.add(noteOn);
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16L);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();
            Thread.sleep(5000L);
            player.close();
            System.exit(0);
        } catch (Exception var13) {
            var13.printStackTrace();
        }

    }
}
