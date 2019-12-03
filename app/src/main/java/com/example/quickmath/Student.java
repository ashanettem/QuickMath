package com.example.quickmath;

import com.example.quickmath.User;

public class Student extends User {
    private String role;

    public Student(){

    }

    public Student(String firstName, String lastName, String email, String age, String password, String role) {
        super(firstName, lastName, email, age, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
