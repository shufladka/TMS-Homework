/*
Сделать форму поиска фильмов по следующим критериям
	название (частичное совпадение)
	жанр
	рейтинг (от и до)
Поиск реализовать при помощи - specification
Сделать на UI отображение найденных фильмов
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
