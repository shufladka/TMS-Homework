/*
Написать программу для вывода названия поры года
по номеру месяца.
При решении используйте оператор if-else-if.
*/

import java.util.Scanner;

public class ControlStructures2 {
    public static void main(String[] args) {

        // вывод сообщения на консоль о просьбе ввода номера месяца
        System.out.print("Введите номер месяца: ");

        // инициализация переменной для ввода целочисленного значения с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int numberOfMonth = scanner.nextInt();

        // определение поры года по номеру месяца
        if (numberOfMonth == 12 || numberOfMonth == 1 || numberOfMonth == 2)
            System.out.print("Пора года: зима.");
        else if (numberOfMonth >= 3 && numberOfMonth <= 5)
                System.out.print("Пора года: весна.");
            else if (numberOfMonth >= 6 && numberOfMonth <= 8)
                    System.out.print("Пора года: лето.");
                else if (numberOfMonth >= 9 && numberOfMonth <= 11)
                        System.out.print("Пора года: осень.");
                    else System.out.print("Ошибка: некорректный номер месяца.");
    }
}