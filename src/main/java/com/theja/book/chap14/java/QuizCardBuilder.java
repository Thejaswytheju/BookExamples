package com.theja.book.chap14.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList cardList;
    private JFrame frame;

    public QuizCardBuilder() {
    }

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {
        this.frame = new JFrame("Quiz Card Builder");
        this.frame.setDefaultCloseOperation(3);
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", 1, 24);
        this.question = new JTextArea(6, 20);
        this.question.setLineWrap(true);
        this.question.setWrapStyleWord(true);
        this.question.setFont(bigFont);
        JScrollPane qScroller = new JScrollPane(this.question);
        qScroller.setVerticalScrollBarPolicy(22);
        qScroller.setHorizontalScrollBarPolicy(31);
        this.answer = new JTextArea(6, 20);
        this.answer.setLineWrap(true);
        this.answer.setWrapStyleWord(true);
        this.answer.setFont(bigFont);
        JScrollPane aScroller = new JScrollPane(this.answer);
        aScroller.setVerticalScrollBarPolicy(22);
        aScroller.setHorizontalScrollBarPolicy(31);
        JButton nextButton = new JButton("Next Card");
        this.cardList = new ArrayList();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new QuizCardBuilder.NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new QuizCardBuilder.NewMenuListener());
        saveMenuItem.addActionListener(new QuizCardBuilder.SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        this.frame.setJMenuBar(menuBar);
        this.frame.getContentPane().add("Center", mainPanel);
        this.frame.setSize(500, 600);
        this.frame.setVisible(true);
    }

    private void clearCard() {
        this.question.setText("");
        this.answer.setText("");
        this.question.requestFocus();
    }

    private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            Iterator cardIterator = this.cardList.iterator();

            while(cardIterator.hasNext()) {
                QuizCard card = (QuizCard)cardIterator.next();
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }

            writer.close();
        } catch (IOException var5) {
            System.out.println("couldn't write the cardList out");
            var5.printStackTrace();
        }

    }

    public class NextCardListener implements ActionListener {
        public NextCardListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(QuizCardBuilder.this.question.getText(), QuizCardBuilder.this.answer.getText());
            QuizCardBuilder.this.cardList.add(card);
            QuizCardBuilder.this.clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener {
        public SaveMenuListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(QuizCardBuilder.this.question.getText(), QuizCardBuilder.this.answer.getText());
            QuizCardBuilder.this.cardList.add(card);
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(QuizCardBuilder.this.frame);
            QuizCardBuilder.this.saveFile(fileSave.getSelectedFile());
        }
    }

    public class NewMenuListener implements ActionListener {
        public NewMenuListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            QuizCardBuilder.this.cardList.clear();
            QuizCardBuilder.this.clearCard();
        }
    }
}
