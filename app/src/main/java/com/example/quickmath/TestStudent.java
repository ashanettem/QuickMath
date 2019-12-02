package com.example.quickmath;

import java.io.Serializable;

public class TestStudent implements Serializable {

    private int score;
    private String UID;
    private int testNumber;

    public TestStudent(){

    }

    public TestStudent(int score, String UID, int testNumber){
        this.score = score;
        this. UID = UID;
        this.testNumber = testNumber;
    }

    public int getScore() {
        return score;
    }

    public String getUID() {
        return UID;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
