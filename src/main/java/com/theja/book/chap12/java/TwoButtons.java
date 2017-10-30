package com.theja.book.chap12.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame frame;
    JLabel label;

    public TwoButtons() {
    }

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(3);
        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new TwoButtons.LabelButtonListener());
        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new TwoButtons.ColorButtonListener());
        this.label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();
        this.frame.getContentPane().add("South", colorButton);
        this.frame.getContentPane().add("Center", drawPanel);
        this.frame.getContentPane().add("East", labelButton);
        this.frame.getContentPane().add("West", this.label);
        this.frame.setSize(420, 300);
        this.frame.setVisible(true);
    }

    class LabelButtonListener implements ActionListener {
        LabelButtonListener() {
        }

        public void actionPerformed(ActionEvent event) {
            TwoButtons.this.label.setText("Ouch!");
        }
    }

    class ColorButtonListener implements ActionListener {
        ColorButtonListener() {
        }

        public void actionPerformed(ActionEvent event) {
            TwoButtons.this.frame.repaint();
        }
    }
}

