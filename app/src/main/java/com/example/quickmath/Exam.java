package com.example.quickmath;

public class Exam {
    private String type;
    private int num;

    public Exam() {
    }

    public Exam(String type, int num) {
        this.type = type;
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
