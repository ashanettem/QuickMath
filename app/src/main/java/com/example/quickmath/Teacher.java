package com.example.quickmath;

public class Teacher extends User {

    private String role;

    public Teacher() {    }

    public Teacher(String firstName, String lastName, String email, String age, String password, String role) {
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
