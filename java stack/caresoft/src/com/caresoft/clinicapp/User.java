package com.caresoft.clinicapp;

public abstract class User {
    protected Integer id;
    protected int pin;

    public User(Integer id) {
        this.id = id;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }
}
