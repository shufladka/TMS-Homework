package org.tms.structure;

public class Worker extends Employee {

    public Worker(String firstName, String lastName, int workExperience) {
        super(firstName, lastName, workExperience);
    }

    // метод для вывода на консоль информации в формате ...
    public void showInformation() {
        System.out.print("Сотрудник: " + super.getFirstName() + " " + super.getLastName() + ". ");
        salaryCalculation();
    }

    @Override
    public Staff getPosition() {
        return Staff.WORKER;
    }
}