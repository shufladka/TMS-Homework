/*
Написать программу для вывода названия поры года
по номеру месяца.
При решении используйте оператор switch-case.
*/

import java.util.Scanner;

public class ControlStructures1 {
    public static void main(String[] args) {

        // вывод сообщения на консоль о просьбе ввода номера месяца
        System.out.print("Введите номер месяца: ");

        // инициализация переменной для ввода целочисленного значения с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int numberOfMonth = scanner.nextInt();

        // определение поры года по номеру месяца
        switch (numberOfMonth)
        {
            case 12:
            case 1:
            case 2:
                System.out.print("Пора года: зима.");
                break;
            case 3:
            case 4:
            case 5:
                System.out.print("Пора года: весна.");
                break;
            case 6:
            case 7:
            case 8:
                System.out.print("Пора года: лето.");
                break;
            case 9:
            case 10:
            case 11:
                System.out.print("Пора года: весна.");
                break;
            default:
                System.out.print("Ошибка: некорректный номер месяца.");
                break;
        }
    }
}