package org.tms.collections;

import java.util.Arrays;

public class CustomCollectionImpl<T> implements CustomCollection<T> {

    private final int defaultSize = 5;   // размерность массива по умолчанию (равна 5)
    private int elementsCounter = 0;     // счетчик элементов коллекции
    private Object[] array;              // массив элементов типа Object

    public CustomCollectionImpl() {
        array = new Object[defaultSize];
    }

    public CustomCollectionImpl(int customSize) {
        array = new Object[customSize];
    }

    // метод для добавления элементов в коллекцию
    public void add (T t) {

        // расширение коллекции, когда места для нового элемента не хватает
        if (elementsCounter == array.length) {
            expand(array.length + 1);
        }

        // добавление нового элемента в коллекцию и увеличение счетчика хранимых элементов
        array[elementsCounter] = t;
        elementsCounter++;
    }

    // метод для расширения размера коллекции на один элемент
    private void expand(int length) {
        Object[] temporaryArray = new Object[length];
        System.arraycopy(array, 0, temporaryArray, 0, elementsCounter);
        array = temporaryArray;
    }

    // метод для удаления элементов из коллекции
    @Override
    public void remove(int index) {
        if (index < 0 || index >= elementsCounter) {
            System.out.println("Элемента с таким индексом не существует.");
        }
        else {
            for (int i = index; i < elementsCounter - 1; i++) {
                array[i] = array[i + 1];
            }

            // уменьшение размерности массива на 1 элемент
            elementsCounter--;
            expand(elementsCounter);
        }
    }

    // метод для взятия элемента коллекции по индексу
    @Override
    public T getByIndex(int index) {
        if (index < 0 || index >= elementsCounter) {
            System.out.println("Элемента с таким индексом не существует.");
            return null;
        }

        return (T) array[index];
    }

    // метод для проверки на наличие элемента в коллекции
    @Override
    public boolean checkForAvailability(T t) {
        for (Object element : array) {
            if (element.equals(t)) {
                return true;
            }
        }

        return false;
    }

    // метод для очистки содержимого коллекции
    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;

        }

        System.out.println(Arrays.toString(array));
    }

    @Override
    public String toString() {
        return "Элементов в коллекции: " + elementsCounter +
                ", элементы коллекции: " + Arrays.toString(array);
    }
}