package org.tms.collections;

public interface CustomCollection <T> {
    void add(T t);                          // добавление элемента
    void remove(int index);                 // удаление элемента
    T getByIndex (int index);               // взятие элемента по индексу
    boolean checkForAvailability(T t);      // проверка на наличие элемента в коллекции
    void clear();                           // очистка всей коллекции
}