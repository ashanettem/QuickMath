package com.example.quickmath;

public class Child extends User {

     private int age;

    public Child() {    }

    public Child(String firstName, String lastName, String email, String password, String role, int age) {
        super(firstName, lastName, email, password, role);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
