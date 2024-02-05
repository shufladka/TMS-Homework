/*
Написать метод, который принимает две строки и возвращает число.
Данный метод должен искать подстроку (второй параметр) в строке (первый параметр) игнорируя большие и маленькие буквы.
Результат метода - номер индекса с которого начинает данная подстрока или -1 если подстрока не найдена.

Реализовать необходимые unit тесты для данного функционала
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson50Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson50Application.class, args);
    }

}