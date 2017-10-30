package com.theja.book.chap13.java;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BeatBox {

    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    String[] instrumentNames = new String[]{"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = new int[]{35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public BeatBox() {
    }
    public void buildGUI() {
        this.theFrame = new JFrame("Cyber BeatBox");
        this.theFrame.setDefaultCloseOperation(3);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.checkboxList = new ArrayList();
        Box buttonBox = new Box(1);
        JButton start = new JButton("Start");
        start.addActionListener(new BeatBox.MyStartListener());
        buttonBox.add(start);
        JButton stop = new JButton("Stop");
        stop.addActionListener(new BeatBox.MyStopListener());
        buttonBox.add(stop);
        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new BeatBox.MyUpTempoListener());
        buttonBox.add(upTempo);
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new BeatBox.MyDownTempoListener());
        buttonBox.add(downTempo);
        Box nameBox = new Box(1);

        for(int i = 0; i < 16; ++i) {
            nameBox.add(new Label(this.instrumentNames[i]));
        }

        background.add("East", buttonBox);
        background.add("West", nameBox);
        this.theFrame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        this.mainPanel = new JPanel(grid);
        background.add("Center", this.mainPanel);

        for(int i = 0; i < 256; ++i) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            this.checkboxList.add(c);
            this.mainPanel.add(c);
        }

        this.setUpMidi();
        this.theFrame.setBounds(50, 50, 300, 300);
        this.theFrame.pack();
        this.theFrame.setVisible(true);
    }

    public void setUpMidi() {
        try {
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.open();
            this.sequence = new Sequence(0.0F, 4);
            this.track = this.sequence.createTrack();
            this.sequencer.setTempoInBPM(120.0F);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public void buildTrackAndStart() {
        int[] trackList = (int[])null;
        this.sequence.deleteTrack(this.track);
        this.track = this.sequence.createTrack();

        for(int i = 0; i < 16; ++i) {
            trackList = new int[16];
            int key = this.instruments[i];

            for(int j = 0; j < 16; ++j) {
                JCheckBox jc = (JCheckBox)this.checkboxList.get(j + 16 * i);
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

            this.makeTracks(trackList);
            this.track.add(this.makeEvent(176, 1, 127, 0, 16));
        }

        this.track.add(this.makeEvent(192, 9, 1, 0, 15));

        try {
            this.sequencer.setSequence(this.sequence);
            this.sequencer.setLoopCount(-1);
            this.sequencer.start();
            this.sequencer.setTempoInBPM(120.0F);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public void makeTracks(int[] list) {
        for(int i = 0; i < 16; ++i) {
            int key = list[i];
            if (key != 0) {
                this.track.add(this.makeEvent(144, 9, key, 100, i));
                this.track.add(this.makeEvent(128, 9, key, 100, i + 1));
            }
        }

    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, (long)tick);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return event;
    }

    public class MyStartListener implements ActionListener {
        public MyStartListener() {
        }

        public void actionPerformed(ActionEvent a) {
            BeatBox.this.buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public MyStopListener() {
        }

        public void actionPerformed(ActionEvent a) {
            BeatBox.this.sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public MyUpTempoListener() {
        }

        public void actionPerformed(ActionEvent a) {
            float tempoFactor = BeatBox.this.sequencer.getTempoFactor();
            BeatBox.this.sequencer.setTempoFactor((float)((double)tempoFactor * 1.03D));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public MyDownTempoListener() {
        }

        public void actionPerformed(ActionEvent a) {
            float tempoFactor = BeatBox.this.sequencer.getTempoFactor();
            BeatBox.this.sequencer.setTempoFactor((float)((double)tempoFactor * 0.97D));
        }
    }



}
