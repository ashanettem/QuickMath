package com.example.quickmath;

import com.google.firebase.firestore.Exclude;

public class Exam {
    private String type;
    private int numOfQuestions;
    private int score;
    private String child;
    private String parent;

    public Exam() {
    }

    public Exam(String type, int numOfQuestions, String child, int score){
        this.type = type;
        this.child = child;
        this.numOfQuestions =numOfQuestions;
        this.score = score;
    }

    public Exam(String type, int numOfQuestions, String child, String parent) {
        this.type = type;
        this.numOfQuestions = numOfQuestions;
        this.child = child;
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
