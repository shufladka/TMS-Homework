/*
1. Создайте массив целых чисел. Удалите все вхождения заданного
числа из массива.
Пусть число задается с консоли (класс Scanner). Если такого числа нет -
выведите сообщения об этом.
В результате должен быть новый массив без указанного числа.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        // вывод сообщения на консоль о просьбе ввода размерности массива
        System.out.print("Введите размерность массива: ");

        // инициализация переменной для ввода размерности массива с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int originArrayLength = scanner.nextInt();

        // инициализация переменной под исходный массив
        int[] originArray = new int[originArrayLength];

        // заполнение исходного массива случайными значениями от 1 до 30
        for (int i = 0; i < originArrayLength; i++) {
            originArray[i] = 1 + (int) (Math.random() * 30);
        }

        // вывод полученного исходного массива на консоль
        String originArrayList = Arrays.toString(originArray);
        System.out.println("Сгенерированный массив:\n" + originArrayList);

        // вывод сообщения на консоль о просьбе ввода числа, все вхождения которого должны быть удалены из исходного массива
        System.out.print("Введите число, которое должно быть удалено из массива: ");

        // инициализация переменной под удаляемое число и под размерность результирующего массива
        int deleteNumber = scanner.nextInt();
        int resultArrayLength = originArrayLength;

        // поиск количества вхождений удаляемого числа для определения размерности результирующего массива
        for (int i = 0; i < originArrayLength; i++) {
            if (originArray[i] == deleteNumber) {
                resultArrayLength--;  // декрементация счетчика размерности результирующего массива
            }
        }

        // инициализация переменной под результирующий массив и под индекс массива
        int[] resultArray = new int[resultArrayLength];
        int indexResultArray = 0;

        // копирование всех чисел, кроме удаляемых, из исходного массива в результирующий
        for (int i = 0; i < originArrayLength; i++) {
            if (originArray[i] != deleteNumber) {
                resultArray[indexResultArray] = originArray[i];
                indexResultArray++;
            }
        }

        // вывод полученного результирующего массива на консоль
        String resultArrayList = Arrays.toString(resultArray);
        System.out.println("Полученный массив:\n" + resultArrayList);
    }
}