/*
Класс Phone.
Создайте класс Phone, который содержит переменные number, model и
weight.
Создайте три экземпляра этого класса.
Выведите на консоль значения их переменных.
Добавить в класс Phone методы: receiveCall, имеет один параметр – имя
звонящего. Выводит на консоль сообщение “Звонит {name}”. getNumber –
возвращает номер телефона. Вызвать эти методы для каждого из
объектов.
Добавить конструктор в класс Phone, который принимает на вход три
параметра для инициализации переменных класса - number, model и
weight.
Добавить конструктор, который принимает на вход два параметра для
инициализации переменных класса - number, model.
Добавить конструктор без параметров.
Вызвать из конструктора с тремя параметрами конструктор с двумя.
Добавьте перегруженный метод receiveCall, который принимает два
параметра - имя звонящего и номер телефона звонящего. Вызвать этот
метод.
Создать метод sendMessage с аргументами переменной длины. Данный
метод принимает на вход номера телефонов, которым будет отправлено
сообщение. Метод выводит на консоль номера этих телефонов.
*/

package org.tms.service;

public class MainApp {
    public static void main(String[] args) {

        // создаем три экземпляра класса Phone
        Phone phoneOne = new Phone("+375441234567", "iPhone 14 Pro", 206);
        Phone phoneTwo = new Phone("+375297654321", "Samsung Galaxy S23", 168);
        Phone phoneThree = new Phone("+375335553355", "iPhone XR", 194);

        // выводим значения переменных, хранимых этими объектами
        System.out.println("Первый телефон имеет следующие параметры: \n" + "Номер: " + phoneOne.getNumber() + ", модель: " + phoneOne.getModel() + ", вес: " + phoneOne.getWeight() + " грамм.");
        System.out.println("Второй телефон имеет следующие параметры: \n" + "Номер: " + phoneTwo.getNumber() + ", модель: " + phoneTwo.getModel() + ", вес: " + phoneTwo.getWeight() + " грамм.");
        System.out.println("Третий телефон имеет следующие параметры: \n" + "Номер: " + phoneThree.getNumber() + ", модель: " + phoneThree.getModel() + ", вес: " + phoneThree.getWeight() + " грамм.");

        // для удобства чтения данных с консоли разделим строки смысловыми пробелами
        System.out.println(" ");

        // вызываем методы receiveCall и getNumber для каждого из объектов
        phoneOne.receiveCall("Павел");
        System.out.println("Номер: " + phoneOne.getNumber());
        phoneTwo.receiveCall("Константин");
        System.out.println("Номер: " + phoneTwo.getNumber());
        phoneThree.receiveCall("Николай");
        System.out.println("Номер: " + phoneThree.getNumber());

        // для удобства чтения данных с консоли разделим строки смысловыми пробелами
        System.out.println(" ");

        // вызываем перегруженный метод receiveCall
        phoneOne.receiveCall("Павел", phoneOne.getNumber());
        phoneTwo.receiveCall("Константин", phoneTwo.getNumber());
        phoneThree.receiveCall("Николай", phoneThree.getNumber());

        // для удобства чтения данных с консоли разделим строки смысловыми пробелами
        System.out.println(" ");

        // вызываем метод, который выводит на консоль номера телефонов, которым будет отправлено сообщение
        System.out.println("Сообщение будет отправлено следующим номерам:");
        String[] listNumbers = { phoneOne.getNumber(), phoneTwo.getNumber(), phoneThree.getNumber() };
        new Phone().sendMessage(listNumbers);
    }
}
