package org.tms.processing;

public class DocumentProcessing {

    // метод, который выводит на консоль первые два блока по 4 цифры в одну строку
    public static void printFirstBlocksDigits (String string) {
        System.out.println(string.substring(0,4) + string.substring(9,13));
    }

    // метод, который выводит на консоль номер документа, где блоки из трех букв заменены на ***
    public static void printEncryptedNumber (String string) {
        System.out.println(string.substring(0,5)
                + "***" + string.substring(8,14)
                + "***" + string.substring(17,22));
    }

    // метод, который выводит на консоль только буквенные символы номера документа в формате yyy/yyy/y/y в нижнем регистре
    public static void printLettersLowerCase (String string) {
        System.out.println(string.toLowerCase().substring(5,8) + "/"
                + string.toLowerCase().substring(14,17) + "/"
                + string.toLowerCase().charAt(19) + "/"
                + string.toLowerCase().charAt(21));
    }

    // метод, который выводит на консоль только буквенные символы номера документа в формате yyy/yyy/y/y в верхнем регистре (используя StringBuilder)
    public static void printLettersUpperCase (StringBuilder string) {
        System.out.println("Letters: "
                + string.substring(5,8).toUpperCase() + "/"
                + string.substring(14,17).toUpperCase() + "/"
                + string.substring(19,20).toUpperCase() + "/"
                + string.substring(21,22).toUpperCase());
    }

    // метод, который проверяет, содержит ли номер документа последовательность abc
    public static void contentCheckABC (String string) {
        System.out.println(string.toLowerCase().contains("abc")
                ? "Номер документа содержит последовательность abc."
                : "Номер документа не содержит последовательность abc.");
    }

    // метод, который проверяет, начинается ли номер документа с последовательности 555
    public static void contentCheckStartsWith (String string) {
        System.out.println(string.startsWith("555")
                ? "Номер документа начинается с последовательности 555."
                : "Номер документа не начинается с последовательности 555.");
    }

    // метод, который проверяет, заканчивается ли номер документа последовательностью 1a2b
    public static void contentCheckEndsWith (String string) {
        System.out.println(string.endsWith("1a2b")
                ? "Номер документа заканчивается последовательностью 1a2b."
                : "Номер документа не заканчивается последовательностью 1a2b.");
    }
}