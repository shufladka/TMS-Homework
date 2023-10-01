package org.tms.patterns.observer;

public class EmployeeActions {

    private Employee employee;
    private Action action;

    public EmployeeActions(Employee employee, Action action) {
        this.employee = employee;
        this.action = action;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Action getAction() {
        return action;
    }
}