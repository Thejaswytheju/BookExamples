package com.theja.book.chap9.java;

public class SimUnit {

    String botType;

    public SimUnit(String type) {

        this.botType = type;
    }

    public int powerUse() {

        return "Retention".equals(this.botType) ? 2 : 4;
    }
}
