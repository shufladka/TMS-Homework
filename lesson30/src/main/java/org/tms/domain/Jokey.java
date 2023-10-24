package org.tms.domain;

public class Jokey {

    private String firstName;    // имя всадника
    private String lastName;     // фамилия всадника

    public Jokey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "жокей '" + firstName +  " " + lastName + "'";
    }
}