/*
2. Создайте и заполните массив случайным числами и выведете
максимальное, минимальное и среднее значение.
Для генерации случайного числа используйте метод Math.random().
Пусть будет возможность создавать массив произвольного размера.
Пусть размер массива вводится с консоли.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
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

        // инициализация переменных под хранение максимального числа, минимального числа и суммы элементов, хранимых в массиве
        int maxNumber = array[0];
        int minNumber = array[0];
        int sumOfElements = 0;

        // поиск максимального числа, минимального числа и подсчет суммы элементов массива
        for (int i = 0; i < arrayLength; i++) {
            if (maxNumber < array[i]) {
                maxNumber = array[i];
            }

            if (minNumber > array[i]) {
                minNumber = array[i];
            }

            sumOfElements += array[i];
        }

        System.out.println("Максимальное число в массиве: " + maxNumber);
        System.out.println("Минимальное число в массиве: " + minNumber);
        System.out.println("Среднее значение: " + ((float) sumOfElements / arrayLength));
    }
}
