package com.example.api.domain;

public class CardHolder {

    private int id;
    private String name;
    private String lastName;

    public CardHolder() {
    }

    public CardHolder(final int id, final String name, final String lastName) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
