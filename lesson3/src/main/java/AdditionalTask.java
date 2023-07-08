// Напишите программу, которая выводит на консоль таблицу умножения.

public class AdditionalTask {
    public static void main(String[] args) {

        // цикл вывода на консоль таблицы умножения
        for (int firstNumber = 1; firstNumber <= 10; firstNumber++)
        {
            for (int secondNumber = 1; secondNumber <= 10; secondNumber++)
                System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));

            // вывод пустой строки для удобного чтения информации, выведенной на консоль
            System.out.println(" ");
        }
    }
}