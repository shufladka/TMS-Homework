/*
lesson43:
Необходимо создать два модуля - il и bl уровней
Bl - должен иметь ендпоинт по сохранению машины (любое количество полей) и связь с БД
IL - должен иметь так же ендпоинт по сохранению машины
Задача - вызвав IL ендпоинт необходимо при помощи RestTemplate сделать запрос в BL слой для сохранения в БД машины

lesson44:
Обновляем предыдущее дом задание
1) переходим от использования RestTemplate на FeignClient
2) добавляем методы для получения всех сохраненных машин
3) добавляем методы для получения машины по ид
4) если ид машины не существует то возвращаем объект, который описывает проблему (описание ошибки, сведения об используемом ид)
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson43BlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson43BlApplication.class, args);
    }

}
