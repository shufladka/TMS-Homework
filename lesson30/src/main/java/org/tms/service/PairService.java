package org.tms.service;

import org.tms.domain.Pairs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class PairService {

    private final List<Pairs> pairs;

    public PairService(List<Pairs> pairs) {
        this.pairs = pairs;
    }

    public Pairs setPairs() {

        Scanner scanner = new Scanner(System.in);
        int selectedPair;

        // вывод на консоль всех пар
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println((i + 1) + "-я " + pairs.get(i));
        }

        System.out.print("Выберите желаемую пару: ");
        selectedPair = scanner.nextInt();

        // декрементация выбранной пары для правильной работы программы
        selectedPair -= 1;

        // в случае неправильного выбора пары заставляем пользователя ввести пару ещё раз
        while (selectedPair < 0 || (selectedPair > pairs.size() - 1)) {
            System.out.println("К сожалению, такой пары нет. Попробуйте ещё раз.");
            System.out.print("Выберите желаемую пару: ");
            selectedPair = scanner.nextInt();

            // декрементация выбранной пары для правильной работы программы
            selectedPair -= 1;
        }

        return pairs.get(selectedPair);
    }

    public Pairs getWinner() {

        List<Double> race = new ArrayList<>();

        // проходимся по массиву пар
        for (Pairs pair : pairs) {
            race.add(pair.getHorse().getSpeedCoef());
        }

        // возвращаем ту пару, в которой лошадь двигалась быстрее остальных
        return pairs.get(race.indexOf(Collections.max(race)));
    }

    public List<Pairs> getPairs() {
        return pairs;
    }
}