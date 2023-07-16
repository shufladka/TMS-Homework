package org.tms.office;

public class WorkertImpl implements Position {
    public void PrintPosition(String text) {
        // вывод строки, содержащую название должности, на консоль
        System.out.println(text + "рабочий.");
    }
}