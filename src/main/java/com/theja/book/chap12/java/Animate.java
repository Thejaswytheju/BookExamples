package com.theja.book.chap12.java;

import javax.swing.*;
import java.awt.*;

public class Animate {

    int x = 1;
    int y = 1;

    public Animate() {
    }

    public void go() {
        JFrame var1 = new JFrame();
        var1.setDefaultCloseOperation(3);
        Animate.MyDrawP var2 = new Animate.MyDrawP();
        var1.getContentPane().add(var2);
        var1.setSize(500, 270);
        var1.setVisible(true);

        for (int var3 = 0; var3 < 124; ++this.y) {
            ++this.x;
            var2.repaint();

            try {
                Thread.sleep(50L);
            } catch (Exception var5) {
                ;
            }

            ++var3;
            ++this.x;
        }

    }

    class MyDrawP extends JPanel {
        MyDrawP() {
        }

        public void paintComponent(Graphics var1) {
            var1.setColor(Color.white);
            var1.fillRect(0, 0, 500, 250);
            var1.setColor(Color.blue);
            var1.fillRect(Animate.this.x, Animate.this.y, 500 - Animate.this.x * 2, 250 - Animate.this.y * 2);
        }
    }

}
