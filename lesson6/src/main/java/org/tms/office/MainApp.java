package org.tms.office;

public class MainApp {
    public static void main(String[] args) {
        // создание объекта класса Service для вызова конкретного класса с должностью
        Service service = new Service();

        // вызов методов, которые выводят на консоль названия своих должностей
        service.sendPosition(new DirectortImpl());
        service.sendPosition(new AccountantImpl());
        service.sendPosition(new WorkertImpl());
    }
}