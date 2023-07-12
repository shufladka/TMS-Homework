/*
Для введенного числа t (температура на улице) вывести
Если t>–5, то вывести «Тепло».
Если –5>= t > –20, то вывести «Нормально».
Если –20>= t, то вывести «Холодно».
*/

import java.util.Scanner;

public class ControlStructures4 {
    public static void main(String[] args) {

        // вывод сообщения на консоль о просьбе ввода значения уличной температуры
        System.out.print("Какая температура на улице? (градусы по Цельсию): ");

        // инициализация переменной для ввода целочисленного значения с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int temperature = scanner.nextInt();

        // определение субъективных ощущений от температуры на улице
        if (temperature <= -20) System.out.print("Холодно.");
        if (temperature >= -20 && temperature <= -5) System.out.print("Нормально.");
        if (temperature > -5) System.out.print("Тепло.");
    }
}