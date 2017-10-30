package com.theja.book.chap15.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = new String[]{
            "Take smaller bites",
            "Go for the tight jeans. No they do NOT make you look fat",
            "One word: inappropriate",
            "Just for today, be honest.  Tell your boss what you *really* think",
            "You might want to rethink that haircut"};

    public DailyAdviceServer() {
    }

    public void go() {
        try {
            ServerSocket serverSock = new ServerSocket(4242);

            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = this.getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException var5) {
            var5.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int)(Math.random() * (double)this.adviceList.length);
        return this.adviceList[random];
    }
}
