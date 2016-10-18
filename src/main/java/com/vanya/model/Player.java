package com.vanya.model;

import java.io.Serializable;

/**
 * Created by Hladush Ivan
 * on 16.10.16.
 */
public class Player implements Serializable {
    private String ID;
    private String lastName;
    private String firstName;
    private String position;
    private int birthYear;
    private int debuteYear;

    public Player(){}

    public Player(String ID, String lastName, String firstName, String position, int birthYear, int debuteYear) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.birthYear = birthYear;
        this.debuteYear = debuteYear;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID='" + ID + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", position='" + position + '\'' +
                ", birthYear=" + birthYear +
                ", debuteYear=" + debuteYear +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDebuteYear() {
        return debuteYear;
    }

    public void setDebuteYear(int debuteYear) {
        this.debuteYear = debuteYear;
    }
}
