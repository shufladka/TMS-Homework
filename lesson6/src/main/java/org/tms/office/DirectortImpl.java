package org.tms.office;

public class DirectortImpl implements Position {
    public void PrintPosition(String text) {
        // вывод строки, содержащую название должности, на консоль
        System.out.println(text + "директор.");
    }
}