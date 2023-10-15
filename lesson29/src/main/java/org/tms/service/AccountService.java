package org.tms.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.tms.interfaces.AccountInterface;

import java.util.Scanner;

@Service
public class AccountService implements AccountInterface {

    private double balance = 10_000;    // стартовый баланс равен 10 000 условных единиц
    private double bet;                 // величина ставки

    public AccountService() {
    }

    public AccountService(double balance) {
        this.balance = balance;
    }

    public void depositBalance() {
        this.balance = balance + bet;
    }

    public void withdrawBalance() {
        this.balance = balance - bet;
    }

    public void showInfo() {
        System.out.println("Ваш счёт составляет " + balance + " у.е.");
    }

    public void setBet() {

        System.out.print("Введите желаемую ставку: ");
        Scanner scanner = new Scanner(System.in);
        double bet = scanner.nextDouble();

        while (bet <= 0 || bet > balance) {
            System.out.print("К сожалению, такая ставка невозможна. Введите ставку от 1 до " + balance + " у.е.: ");
            bet = scanner.nextDouble();
        }

        this.bet = bet;
    }

    public double getBalance() {
        return balance;
    }

    public double getBet() {
        return bet;
    }
}