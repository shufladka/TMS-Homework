package org.tms.office;

public class DirectorImpl implements Position {
    public void PrintPosition(String text) {

        // вывод строки, содержащую название должности, на консоль
        System.out.println(text + EnumPosition.DIRECTOR.getPosition());
    }
}