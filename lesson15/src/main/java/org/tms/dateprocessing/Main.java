/*
1. Написать программу для вывода на консоль названия дня недели по введенной дате.
2. Написать программу для вывода на экран дату следующего вторника.
*/

package org.tms.dateprocessing;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ------ ЗАДАНИЕ 1 ------
        // создание объекта класса Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // вывод текстового сообщения с просьбой ввода даты в заданном формате
        System.out.println("Enter date in dd.MM.yyyy format: ");

        try {

            // преобразуем введенную дату формата dd.MM.yyyy в объект класса LocalDate и, если дата введена корректно,
            // находим день недели по интересующей дате и выводим на консоль
            String dayOfWeek = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                    .getDayOfWeek()
                    .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            System.out.println("Day of the week: " + dayOfWeek);
        }
        catch (Exception exc) {

            // иначе выводим на консоль сообщение об ошибке
            System.out.println("Check if the entered data is correct.");
        }

        // переносим каретку на одну строку вниз для удобства чтения консоли
        System.out.println(" ");

        // ------ ЗАДАНИЕ 2 ------
        // находим дату следующего вторника и выводим на консоль в формате dd.MM.yyyy
        String nextTuesday = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Date of next Tuesday: " + nextTuesday);
    }
}