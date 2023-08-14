/*
1. Допустим есть txt файл с номерами документов.
Номером документа является строка, состоящая из букв и цифр(без
служебных символов).
Пусть этот файл содержит каждый номер документа с новой строки и в
строке никакой другой информации, только номер документа.
Валидный номер документа должен иметь длину 15 символов и
начинаться с последовательности docnum(далее любая
последовательность букв/цифр) или contract(далее любая
последовательность букв/цифр).
Написать программу для чтения информации из входного файла - путь к
входному файлу должен задаваться через консоль.
Программа должна проверять номера документов на валидность.

2. Улучшить предыдущее задание. А именно:
Валидные номера документов следует записать в один файл-отчет.
Невалидные номера документов следует записать в другой файл-отчет,
но после номеров документов следует добавить информацию о том,
почему этот документ невалиден.
*/

package org.tms.fileprocessing;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Путь к входному файлу: ");
        String readerFilePath = scanner.nextLine();

        // задаем путь к файлам, где должны храниться валидные и невалидные номера документов
        // String readerFilePath = "lesson10/src/main/resources/docnames.txt";
        String validFilePath = "lesson10/src/main/resources/valid.txt";
        String invalidFilePath = "lesson10/src/main/resources/invalid.txt";

        try (LineNumberReader reader = new LineNumberReader(new BufferedReader(new FileReader(readerFilePath)));
             Writer validWriter = new FileWriter(validFilePath);
             Writer invalidWriter = new FileWriter(invalidFilePath)) {

            // чтение первой строки входного файла
            String string = reader.readLine();

            // проход по файлу в поиске валидных и невалидных номеров документов
            while (string != null) {

                // если номер документа валиден, записываем его в соответствующий файл и выводим на консоль
                if (isValidName(string)) {
                    validWriter.write(string + "\n");

                    System.out.println(string + " - валидный номер документа.");
                }

                // иначе записываем его в файл с невалидными номерами документов с причиной некорректности и выводим на консоль
                else {
                    invalidWriter.write(string + " . is invalid. Reason: incorrect name.\n");

                    System.out.println(string + " - невалидный номер документа. Причина: некорректное имя");
                }

                // переходим к чтению следующей строки во входном файле
                string = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println("\nОшибка: входной файл не был найден.");
        }
    }

    // метод для проверки имени документа на соответствие условию
    private static boolean isValidName (String string) {

        if (string.length() == 15) {
            if (string.startsWith("docnum") || string.startsWith("contract")) {
                for (int i = 0; i < string.length(); i++) {

                    // проверка на соответствие символа букве или цифре согласно таблице ASCII
                    if ((string.charAt(i) >= 48 && string.charAt(i) <= 57)
                            || (string.toLowerCase().charAt(i) >= 97 && string.toLowerCase().charAt(i) <= 122)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}