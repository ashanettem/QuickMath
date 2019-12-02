package com.example.quickmath;

import java.io.Serializable;

public class TestStudent implements Serializable {

    private String score;
    private String UID;
    private String testNumber;

    public TestStudent(){

    }

    public TestStudent(String score, String UID, String testNumber){
        this.score = score;
        this. UID = UID;
        this.testNumber = testNumber;
    }

    public String getScore() {
        return score;
    }

    public String getUID() {
        return UID;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setTestNumber(String testNumber) {
        this.testNumber = testNumber;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
