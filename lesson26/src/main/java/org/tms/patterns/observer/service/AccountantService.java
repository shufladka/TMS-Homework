package org.tms.patterns.observer.service;

import org.tms.patterns.observer.Action;
import org.tms.patterns.observer.EmployeeActions;

import java.util.Observable;
import java.util.Observer;

public class AccountantService implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof EmployeeActions) {

            var actions = (EmployeeActions) arg;

            if (actions.getAction() == Action.CREATE) {
                System.out.println("The account of " + actions.getEmployee().getFirstName() + " " + actions.getEmployee().getLastName() + " (" + actions.getEmployee().getPosition() + ") was created.");
            }

            if (actions.getAction() == Action.DISMISS) {
                System.out.println("The account of " + actions.getEmployee().getFirstName() + " " + actions.getEmployee().getLastName() + " (" + actions.getEmployee().getPosition() + ") was deleted.");
            }
        }
    }
}