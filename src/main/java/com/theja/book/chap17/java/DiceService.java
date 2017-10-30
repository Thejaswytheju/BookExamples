package com.theja.book.chap17.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceService implements Service{
    JLabel label;
    JComboBox numOfDice;

    public DiceService() {
    }

    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll 'em!");
        String[] choices = new String[]{"1", "2", "3", "4", "5"};
        this.numOfDice = new JComboBox(choices);
        this.label = new JLabel("dice values here");
        button.addActionListener(new DiceService.RollEmListener());
        panel.add(this.numOfDice);
        panel.add(button);
        panel.add(this.label);
        return panel;
    }

    public class RollEmListener implements ActionListener {
        public RollEmListener() {
        }

        public void actionPerformed(ActionEvent ev) {
            String diceOutput = "";
            String selection = (String)DiceService.this.numOfDice.getSelectedItem();
            int numOfDiceToRoll = Integer.parseInt(selection);

            for(int i = 0; i < numOfDiceToRoll; ++i) {
                int r = (int)(Math.random() * 6.0D + 1.0D);
                diceOutput = diceOutput + " " + r;
            }

            DiceService.this.label.setText(diceOutput);
        }
    }

}
