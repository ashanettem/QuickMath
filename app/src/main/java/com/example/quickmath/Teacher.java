package com.example.quickmath;

public class Teacher extends User {

    private String role;

    public Teacher() {    }

    public Teacher(String firstName, String lastName, String email, String password, String childEmail, String role) {
        super(firstName, lastName, email, password, childEmail);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
