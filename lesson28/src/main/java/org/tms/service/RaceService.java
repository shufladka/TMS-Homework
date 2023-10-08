package org.tms.service;

import org.tms.domain.Pairs;

import java.util.Random;

public class RaceService {

    private final AccountService accountService;
    private final PairService pairService;

    public RaceService(AccountService accountService, PairService pairService) {
        this.accountService = accountService;
        this.pairService = pairService;
    }

    public void game() {
        if (accountService.getBalance() > 0) {

            // выбор интересующей пары
            Pairs selectedPair = pairService.setPairs();

            // выбор ставки
            accountService.setBet();

            System.out.println("Подробнее о ставке: " + selectedPair.toString() + "; размер ставки: " + accountService.getBet() + " у.е. Удачи!");

            // старт игры
            startGame();

            System.out.println("Определён победитель! Выиграла " + pairService.getWinner().toString());

            if (selectedPair.equals(pairService.getWinner())) {
                accountService.depositBalance();
                System.out.println("Ваш баланс пополнился на " + accountService.getBet() + " и составляет " + accountService.getBalance() + " у.е.");

            } else {
                accountService.withdrawBalance();
                System.out.println("Ваш баланс уменьшился на " + accountService.getBet() + " и составляет " + accountService.getBalance() + " у.е.");
            }
        } else {
            System.out.println("К сожалению, на Вашем счёте недостаточно средств. Для пополнения обратитесь в кассу.");
        }
    }

    public void startGame() {

        int numberOfLaps = 5;    // число заездов

        System.out.println("Скачки начались!");
        for (int i = 0; i < numberOfLaps; i++) {
            try {

                pairService.getPairs().stream()
                        .map(Pairs -> Pairs.getHorse())
                        .forEach(horse -> { horse.setSpeedCoef(horse.getSpeedCoef() + new Random().nextDouble()); });

                Thread.sleep(1000);
                System.out.println((i + 1) + "-й круг пройден...");

            } catch (InterruptedException exc) {

            }
        }
    }
}