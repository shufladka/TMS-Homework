package org.tms.service;

import java.util.Arrays;

public class Phone {

    // инициализация переменных number, model и weight
    public String number;
    public String model;
    public int weight;

    // конструктор класса, принимающий на вход ни одного параметра
    public Phone() {
    }

    // конструктор класса, принимающий на вход 2 параметра
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // конструктор класса, принимающий на вход 3 параметра
    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    // метод, который возвращает номер телефона
    public String getNumber() {
        return number;
    }

    // метод, который возвращает модель телефона
    public String getModel() {
        return model;
    }

    // метод, который возвращает вес телефона
    public int getWeight() {
        return weight;
    }

    // метод, который выводит на консоль имя звонящего
    public void receiveCall (String name) {
        System.out.print("Звонит: " + name + ". ");
    }

    // перегруженный метод, который выводит на консоль имя звонящего и его номер
    public void receiveCall (String name, String number) {
        System.out.println("Звонит: " + name + ". Номер: " + number);
    }

    // метод, который организует рассылку сообщений на полученные номера телефонов (в нашем случае выводит их на консоль)
    public void sendMessage (String ... number) {
        System.out.println(Arrays.deepToString(number));
    }
}
