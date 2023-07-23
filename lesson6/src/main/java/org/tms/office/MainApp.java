/*
2. Создать классы "Директор", "Рабочий", "Бухгалтер".
Реализовать интерфейс с методом, который печатает название
должности и имплементировать этот метод в созданные классы
*/

package org.tms.office;

public class MainApp {
    public static void main(String[] args) {

        // создание экземпляров классов "Директор", "Рабочий", "Бухгалтер"
        DirectorImpl director = new DirectorImpl();
        WorkerImpl worker = new WorkerImpl();
        AccountantImpl accountant = new AccountantImpl();

        // создание переменной, хранящей общую строку
        String text = "Моя должность: ";

        // вызов методов, печатающих название каждой должности
        director.PrintPosition(text);
        worker.PrintPosition(text);
        accountant.PrintPosition(text);
    }
}