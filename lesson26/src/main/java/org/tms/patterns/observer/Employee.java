package org.tms.patterns.observer;

import java.util.Observable;

public class Employee extends Observable {

    private String firstName;
    private String lastName;
    private String position;

    public Employee(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public void create () {

        System.out.println("Search for an employee in the database...");

        setChanged();
        notifyObservers(new EmployeeActions(this, Action.CREATE));
    }

    public void changePosition (String position) {
        this.position = position;

        setChanged();
        notifyObservers(new EmployeeActions(this, Action.CHANGE_POSITION));
    }

    public void delete () {
        setChanged();
        notifyObservers(new EmployeeActions(this, Action.DISMISS));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }
}