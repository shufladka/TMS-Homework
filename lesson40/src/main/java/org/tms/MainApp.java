/*
Страницу создания записи о фильме перевести на thymeleaf
Реализовать возможность изменения рейтинга фильма
Id фильма для обновления рейтинга отправить как PathVariable
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
