package com.example.api.domain;

public class CardHolder {

    private String name;
    private String lastName;

    public CardHolder(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "name: " + name + ", lastName: " + lastName;
    }
}
