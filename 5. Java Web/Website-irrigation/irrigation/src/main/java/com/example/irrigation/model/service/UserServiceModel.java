package com.example.irrigation.model.service;

public class UserServiceModel{

    private  String firstName;
    private  String lastName;

    public UserServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
