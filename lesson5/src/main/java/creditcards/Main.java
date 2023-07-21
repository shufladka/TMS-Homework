/*
1. Создать класс org.tms.creditcards.CreditCard c полями номер счета, текущая сумма на счету.
Добавьте метод, который позволяет начислять сумму на кредитную
карточку.
Добавьте метод, который позволяет снимать с карточки некоторую сумму.
Добавьте метод, который выводит текущую информацию о карточке.
Напишите программу, которая создает три объекта класса org.tms.creditcards.CreditCard, у которых заданы номер счета и начальная сумма.
Тестовый сценарий для проверки:
Положите деньги на первые две карточки и снимите с третьей.
Выведите на экран текущее состояние всех трех карточек.
*/

package creditcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // создание объектов класса org.tms.creditcards.CreditCard
        CreditCard creditCardOne = new CreditCard("10523D", 0);
        CreditCard creditCardTwo = new CreditCard("75311A", 1250);
        CreditCard creditCardThree = new CreditCard("24683Z", 6253);

        // создание объекта класса Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // тестовый сценарий для проверки:
        //     пополнение счета первой карты
        System.out.print("Введите сумму денег, которые Вы собираетесь положить на счет №" + creditCardOne.getAccountNumber() + ": ");
        creditCardOne.deposit(scanner.nextInt());

        //     пополнение счета второй карты
        System.out.print("\nВведите сумму денег, которые Вы собираетесь положить на счет №" + creditCardTwo.getAccountNumber() + ": ");
        creditCardTwo.deposit(scanner.nextInt());

        //     снятие денег со счета третьей карты
        System.out.print("\nВведите сумму денег, которые Вы собираетесь снять со счета №" + creditCardThree.getAccountNumber() + ": ");
        creditCardThree.withdraw(scanner.nextInt());
    }
}