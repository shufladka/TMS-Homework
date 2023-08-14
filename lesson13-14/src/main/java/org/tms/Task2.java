/*
2. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе.
С помощью Stream'ов:
- Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
- Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
- Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
*/

package org.tms;

import java.util.List;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {

        // создаем коллекцию класса ArrayList
        List<String> studentsList = new ArrayList<>();

        // наполняем коллекцию именами студентов группы
        studentsList.add("Konstantin");
        studentsList.add("Leonid");
        studentsList.add("Pavel");
        studentsList.add("Anton");
        studentsList.add("Sergey");
        studentsList.add("Oleg");
        studentsList.add("Stanislav");
        studentsList.add("Aleksandr");

        // возвращаем количество людей с заданным именем
        String neededName = "OLEG";
        int amountOfPeople = studentsList.stream().filter(name -> name.equalsIgnoreCase(neededName)).toList().size();
        System.out.println("Количество студентов с заданным именем " + neededName + ": " + amountOfPeople);

        // выводим все имена, начинающиеся с "а"
        List<String> namesStartsWithA = studentsList.stream().filter(name -> name.toLowerCase().startsWith("a")).toList();
        System.out.println("Студенты, чье имя начинается на 'а': " + namesStartsWithA);

        // отсортировываем коллекцию и выводим первый элемент (иначе печатаем "Empty")
        String sortedCollection = studentsList.stream().sorted().findFirst().orElse("Empty");
        System.out.println("Первое имя в отсортированном (прямой порядок) списке студентов: " + sortedCollection);
    }
}