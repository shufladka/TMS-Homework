package org.tms.structure;

public class Director extends Employee {

    Employee[] employees = new Employee[20];

    public Director(String firstName, String lastName, int workExperience) {
        super(firstName, lastName, workExperience);
    }

    // метод для перерасчета заработной платы директору
    @Override
    public void salaryCalculation () {
        double workExperienceMF = workExperienceMFRecalculation(workExperience);
        System.out.println("Зарплата: " + (int)(Staff.DIRECTOR.getBaseRate() * Staff.DIRECTOR.getMultiplyingFactor() * workExperienceMF) + " рублей");
    }

    @Override
    public Staff getPosition() {
        return Staff.DIRECTOR;
    }

    // метод для вывода на консоль информации в формате ...
    public void showInformation() {
        System.out.print("Сотрудник: " + super.getFirstName() + " " + super.getLastName() + ". ");
        salaryCalculation();
    }

    // метод для добавления новых подчиненных под управление директора
    public void addSubordinates(Employee toAdd) {
        System.out.println("Обновлено: произошли изменения в штатной численности организации.");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = toAdd;
                break;
            }
        }
    }

    // метод для вывода на консоль информации о подчиненных данного директора
    public void printSubordinates(Employee currentDirector) {
        System.out.println("Руководитель " + currentDirector.getFirstName() + " " + currentDirector.getLastName() + " имеет в своем подчинении следующих работников:");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    // метод для определения количества подчиненных
    public int sumOfSubordinates () {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}