/*
3. Создайте 2 массива из 5 чисел.
Выведите массивы на консоль в двух отдельных строках.
Посчитайте среднее арифметическое элементов каждого массива и
сообщите, для какого из массивов это значение оказалось больше (либо
сообщите, что их средние арифметические равны).
*/

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        // инициализация переменной под массивы
        int[] firstArray = new int[5];
        int[] secondArray = new int[5];

        // заполнение массивов случайными значениями от 1 до 30
        for (int i = 0; i < 5; i++) {
            firstArray[i] = 1 + (int) (Math.random() * 30);
            secondArray[i] = 1 + (int) (Math.random() * 30);
        }

        // вывод полученных массива на консоль
        String firstArrayList = Arrays.toString(firstArray);
        String secondArrayList = Arrays.toString(secondArray);
        System.out.println("Полученные массивы:\n" + firstArrayList + "\n" + secondArrayList);

        // инициализация переменных для подсчета суммы элементов первого и второго массивов
        int sumFirstArray = 0;
        int sumSecondArray = 0;

        // подсчет суммы элементов первого и второго массивов
        for (int i = 0; i < 5; i++) {
            sumFirstArray += firstArray[i];
            sumSecondArray += secondArray[i];
        }

        // инициализация переменных для нахождения средних арифметических значений обоих массивов
        float averageFirstArray = (float) sumFirstArray / 5;
        float averageSecondArray = (float) sumSecondArray / 5;

        if (averageFirstArray > averageSecondArray) {
            System.out.println("Сумма значений первого массива оказалось больше!");
        }
        else {
            if (averageFirstArray < averageSecondArray) {
                System.out.println("Сумма значений второго массива оказалось больше!");
            }
            else {
                System.out.println("Средние арифметические обоих массивов оказались равны.");
            }
        }
    }
}
