/*
1. Создать коллекцию класса ArrayList наполнить ее
рандомными элементами типа Integer.
С помощью Stream'ов:
- Удалить дубликаты
- Вывести все четные элементы в диапазоне от 7 до 17
(включительно)
- Каждый элемент умножить на 2
- Отсортировать и вывести на экран первых 4 элемента
- Вывести количество элементов в стриме
- Вывести среднее арифметическое всех чисел в стриме
*/

package org.tms;

import java.util.List;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {

        // создаем коллекцию класса ArrayList и наполняем её 10-ю рандомными элементами от 1 до 30
        List<Integer> arrayList = new ArrayList<>(new SecureRandom()
                .ints(1,30)
                .limit(10)
                .boxed()
                .toList());
        System.out.println("Начальный массив целых чисел: " + arrayList);

        // удаляем дубликаты
        List<Integer> removedDuplicates = arrayList.stream()
                .distinct()
                .toList();
        System.out.println("Массив без дубликатов: " + removedDuplicates);

        // выводим все четные элементы в диапазоне от 7 до 17 (включительно)
        List<Integer> evenFromSevenToSeventeen = arrayList.stream()
                .filter(element -> element >= 7 && element <= 17)
                .filter(element -> element % 2 == 0)
                .toList();
        System.out.println("Четные элементы в диапазоне от 7 до 17: " + evenFromSevenToSeventeen);

        // умножаем каждый элемент массива на 2
        List<Integer> multipliedByTwo = arrayList.stream()
                .map(element -> element * 2)
                .toList();
        System.out.println("Каждый элемент исходного массива умножен на 2: " + multipliedByTwo);

        // отсортировываем и выводим на экран первые 4 элемента массива
        List<Integer> sortedInReverseOrder = arrayList.stream()
                .sorted(Collections.reverseOrder())
                .limit(4)
                .toList();
        System.out.println("Первые 4 элемента отсортированного по убыванию массива: " + sortedInReverseOrder);

        // выводим количество элементов в стриме
        int amountOfElements = arrayList.stream().toList().size();
        System.out.println("Массив содержит " + amountOfElements + " элементов.");

        // выводим среднее арифметическое всех чисел в стриме
        OptionalDouble averageValue = arrayList.stream().mapToInt(value -> value).average();
        System.out.println("Среднее арифметическое всех чисел в массиве: " + averageValue.orElse(0));
    }
}