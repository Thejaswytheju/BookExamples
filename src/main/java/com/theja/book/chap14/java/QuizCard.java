package com.theja.book.chap14.java;

import java.io.Serializable;

public class QuizCard implements Serializable{
    private String uniqueID;
    private String category;
    private String question;
    private String answer;
    private String hint;

    public QuizCard(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    public void setUniqueID(String id) {
        this.uniqueID = id;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public void setCategory(String c) {
        this.category = c;
    }

    public String getCategory() {
        return this.category;
    }

    public void setQuestion(String q) {
        this.question = q;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswer(String a) {
        this.answer = a;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setHint(String h) {
        this.hint = h;
    }

    public String getHint() {
        return this.hint;
    }
}
