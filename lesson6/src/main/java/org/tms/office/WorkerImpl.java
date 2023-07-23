package org.tms.office;

public class WorkerImpl implements Position {
    public void PrintPosition(String text) {

        // вывод строки, содержащую название должности, на консоль
        System.out.println(text + EnumPosition.WORKER.getPosition());
    }
}