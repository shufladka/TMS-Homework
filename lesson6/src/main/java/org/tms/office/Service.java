package org.tms.office;

public class Service {
    public void sendPosition(Position position) {
        String text = "Моя должность: ";

        // вызов метода для вывода должности на консоль
        position.PrintPosition(text);
    }
}