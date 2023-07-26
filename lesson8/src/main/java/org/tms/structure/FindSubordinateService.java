package org.tms.structure;

public class FindSubordinateService {

    // метод для поиска сотрудников в прямом и косвенном подчинении
    public boolean findSubordinates (String firstName, String lastName, int length, Employee[] ... employeesList) {

        // поиск среди сотрудников в прямом подчинении
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (employeesList[i][j] != null) {
                    System.out.println(employeesList[i][j].toString());
                    if ((employeesList[i][j].getFirstName().equals(firstName)) && (employeesList[i][j].getLastName().equals(lastName))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}