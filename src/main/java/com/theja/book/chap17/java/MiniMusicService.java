package com.theja.book.chap17.java;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMusicService implements Service{
    MiniMusicService.MyDrawPanel myPanel;

    public MiniMusicService() {
    }

    public JPanel getGuiPanel() {
        JPanel mainPanel = new JPanel();
        this.myPanel = new MiniMusicService.MyDrawPanel();
        JButton playItButton = new JButton("Play it");
        playItButton.addActionListener(new MiniMusicService.PlayItListener());
        mainPanel.add(this.myPanel);
        mainPanel.add(playItButton);
        return mainPanel;
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, (long)tick);
        } catch (Exception var8) {
            ;
        }

        return event;
    }

    public class PlayItListener implements ActionListener {
        public PlayItListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();
                sequencer.addControllerEventListener(MiniMusicService.this.myPanel, new int[]{127});
                Sequence seq = new Sequence(0.0F, 4);
                Track track = seq.createTrack();

                for(int i = 0; i < 100; i += 4) {
                    int rNum = (int)(Math.random() * 50.0D + 1.0D);
                    if (rNum < 38) {
                        track.add(MiniMusicService.this.makeEvent(144, 1, rNum, 100, i));
                        track.add(MiniMusicService.this.makeEvent(176, 1, 127, 0, i));
                        track.add(MiniMusicService.this.makeEvent(128, 1, rNum, 100, i + 2));
                    }
                }

                sequencer.setSequence(seq);
                sequencer.start();
                sequencer.setTempoInBPM(220.0F);
            } catch (Exception var7) {
                var7.printStackTrace();
            }

        }
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        MyDrawPanel() {
        }

        public void controlChange(ShortMessage event) {
            this.msg = true;
            this.repaint();
        }

        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        public void paintComponent(Graphics g) {
            if (this.msg) {
                Graphics2D g2 = (Graphics2D)g;
                int r = (int)(Math.random() * 250.0D);
                int gr = (int)(Math.random() * 250.0D);
                int b = (int)(Math.random() * 250.0D);
                g.setColor(new Color(r, gr, b));
                int ht = (int)(Math.random() * 120.0D + 10.0D);
                int width = (int)(Math.random() * 120.0D + 10.0D);
                int x = (int)(Math.random() * 40.0D + 10.0D);
                int y = (int)(Math.random() * 40.0D + 10.0D);
                g.fillRect(x, y, ht, width);
                this.msg = false;
            }

        }
    }

}
