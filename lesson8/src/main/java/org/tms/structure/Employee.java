package org.tms.structure;

public abstract class Employee {

    public String firstName;            // имя
    public String lastName;             // фамилия
    public int workExperience;          // стаж работы

    public Employee(String firstName, String lastName, int workExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
    }

    // метод для возврата строки "должность"
    public abstract Staff getPosition();

    // метод для вывода на консоль информации в формате ...
    public abstract void showInformation();

    // метод для перерасчета повышающего коэффициента за стаж работы
    public double workExperienceMFRecalculation (int workExperience) {

        double workExperienceMF;

        if (workExperience >= 3 && workExperience <= 5) {
            workExperienceMF = 1.1;
        } else if (workExperience >= 6 && workExperience <= 10) {
                workExperienceMF = 1.25;
            } else if (workExperience >= 11) {
                    workExperienceMF = 1.4;
                } else {
                    workExperienceMF = 1.0;
                }

        return workExperienceMF;
    }

    // метод для расчета заработной платы
    public int salaryCalculation () {
        return (int)(Staff.WORKER.getBaseRate() * Staff.WORKER.getMultiplyingFactor() * workExperienceMFRecalculation(workExperience));
    }

    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName + ". Должность: " + getPosition() + ". Стаж работы: " + workExperience + " лет";

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}