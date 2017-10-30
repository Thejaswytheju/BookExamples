package com.theja.book.chap12.java;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public SimpleAnimation() {
    }

    public static void main(String[] var0) {
        SimpleAnimation var1 = new SimpleAnimation();
        var1.go();
    }

    public void go() {
        JFrame var1 = new JFrame();
        var1.setDefaultCloseOperation(3);
        SimpleAnimation.MyDrawPanel var2 = new SimpleAnimation.MyDrawPanel();
        var1.getContentPane().add(var2);
        var1.setSize(300, 300);
        var1.setVisible(true);

        for(int var3 = 0; var3 < 130; ++var3) {
            ++this.x;
            ++this.y;
            var2.repaint();

            try {
                Thread.sleep(50L);
            } catch (Exception var5) {
                ;
            }
        }

    }

    class MyDrawPanel extends JPanel {
        MyDrawPanel() {
        }

        public void paintComponent(Graphics var1) {
            var1.setColor(Color.white);
            var1.fillRect(0, 0, this.getWidth(), this.getHeight());
            var1.setColor(Color.green);
            var1.fillOval(SimpleAnimation.this.x, SimpleAnimation.this.y, 40, 40);
        }
    }
}
