package com.theja.book.chap17.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfTheWeekService implements Service {
    JLabel outputLabel;
    JComboBox month;
    JTextField day;
    JTextField year;

    public DayOfTheWeekService() {
    }

    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Do it!");
        button.addActionListener(new DayOfTheWeekService.DoItListener());
        this.outputLabel = new JLabel("date appears here");
        DateFormatSymbols dateStuff = new DateFormatSymbols();
        this.month = new JComboBox(dateStuff.getMonths());
        this.day = new JTextField(8);
        this.year = new JTextField(8);
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Month"));
        inputPanel.add(this.month);
        inputPanel.add(new JLabel("Day"));
        inputPanel.add(this.day);
        inputPanel.add(new JLabel("Year"));
        inputPanel.add(this.year);
        panel.add(inputPanel);
        panel.add(button);
        panel.add(this.outputLabel);
        return panel;
    }

    public class DoItListener implements ActionListener {
        public DoItListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            int monthNum = DayOfTheWeekService.this.month.getSelectedIndex();
            int dayNum = Integer.parseInt(DayOfTheWeekService.this.day.getText());
            int yearNum = Integer.parseInt(DayOfTheWeekService.this.year.getText());
            Calendar c = Calendar.getInstance();
            c.set(2, monthNum);
            c.set(5, dayNum);
            c.set(1, yearNum);
            Date date = c.getTime();
            String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
            DayOfTheWeekService.this.outputLabel.setText(dayOfWeek);
        }
    }
}
