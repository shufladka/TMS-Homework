/*
0. Создайте массив целых чисел. Напишете программу, которая выводит
сообщение о том, входит ли заданное число в массив или нет.
Пусть число для поиска задается с консоли (класс Scanner).
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task0 {
    public static void main(String[] args) {

        // вывод сообщения на консоль о просьбе ввода размерности массива
        System.out.print("Введите размерность массива: ");

        // инициализация переменной для ввода размерности массива с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();

        // инициализация переменной под массив
        int[] array = new int[arrayLength];

        // заполнение массива случайными значениями от 1 до 30
        for (int i = 0; i < arrayLength; i++) {
            array[i] = 1 + (int) (Math.random() * 30);
        }

        // вывод полученного массива на консоль
        String arrayList = Arrays.toString(array);
        System.out.println("Сгенерированный массив:\n" + arrayList);

        // вывод сообщения на консоль о просьбе ввода искомого числа
        System.out.print("Введите искомое число: ");

        // инициализация переменной под искомое число и флаг обнаруженности искомого числа
        int findNumber = scanner.nextInt();
        boolean wasFound = false;

        // поиск искомого числа в массиве (если число было найдено, флаг меняется на true)
        for (int temp : array) {
            if (temp == findNumber) {
                wasFound = true;
                break;
            }
        }

        // вывод результата программы на консоль
        System.out.println(wasFound ? "Число было найдено." : "Число не было найдено.");
    }
}