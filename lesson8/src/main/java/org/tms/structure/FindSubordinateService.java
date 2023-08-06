package org.tms.structure;

public class FindSubordinateService {

    // метод для поиска сотрудников в прямом и косвенном подчинении
    public boolean findSubordinates(Director director, String firstName, String lastName) {
        for (Employee employee : director.employees) {
            if (employee != null) {

                // если имя и фамилия искомого сотрудника совпадают с подчиненными текущего директора, то возвращаем true
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                    return true;
                }

                // ...иначе пытаемся найти его у подчиненного директора
                else if (employee.getPosition() == Staff.DIRECTOR) {
                    return findSubordinates((Director) employee, firstName, lastName);
                }
            }
        }

        return false;
    }
}