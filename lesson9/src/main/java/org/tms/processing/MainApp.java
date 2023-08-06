/*
Написать программу со следующим функционалом:
На вход передать строку (будем считать, что это номер документа).
Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x — это число,
а y — это буква.
- Вывести на экран в одну строку два первых блока по 4 цифры.
- Вывести на экран номер документа, но блоки из трех букв заменить
на *** (каждая буква заменятся на *).
- Вывести на экран только одни буквы из номера документа в формате
yyy/yyy/y/y в нижнем регистре.
- Вывести на экран буквы из номера документа в формате
"Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью
класса StringBuilder).
- Проверить содержит ли номер документа последовательность abc и
вывеcти сообщение содержит или нет(причем, abc и ABC считается
одинаковой последовательностью).
- Проверить начинается ли номер документа с последовательности
555.
- Проверить заканчивается ли номер документа на
последовательность 1a2b.
Все эти методы реализовать в отдельном классе в статических методах,
которые на вход (входным параметром) будут принимать вводимую на вход
программы строку.
*/

package org.tms.processing;

public class MainApp {
    public static void main(String[] args) {

        // Важно: Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x — это число, а y — это буква.
        String documentNumber = "6249-abc-2535-xml-3b4d";

        // выводим на экран в одну строку два первых блока по 4 цифры
        DocumentProcessing.printFirstBlocksDigits(documentNumber);

        // выводим на экран номер документа, в котором блоки из трех букв заменены на блоки из ***
        DocumentProcessing.printEncryptedNumber(documentNumber);

        // выводим на экран только буквы из номера документа в формате yyy/yyy/y/y в нижнем регистре
        DocumentProcessing.printLettersLowerCase(documentNumber);

        // выводим на экран только буквы из номера документа в формате yyy/yyy/y/y в верхнем регистре (используя StringBuilder)
        StringBuilder stringBuilder = new StringBuilder(documentNumber);
        DocumentProcessing.printLettersUpperCase(stringBuilder);

        // выводим на экран проверку на содержание последовательности abc в номере документа
        DocumentProcessing.contentCheckABC(documentNumber);

        // выводим на экран проверку на начало с последовательности 555 в номере документа
        DocumentProcessing.contentCheckStartsWith(documentNumber);

        // выводим на экран проверку на конец последовательностью 1a2b в номере документа
        DocumentProcessing.contentCheckEndsWith(documentNumber);
    }
}
