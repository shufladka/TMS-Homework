/*
lesson45:
Добавляем к проекту сваггер документацию
Описываем полностью 1 ендпоинт по поиску по ид
	описание контроллера
	описание метода
	описание успешного ответа
	описание ответа в случае ошибки

lesson46:
Добавляем собственную валидацию для предыдущего дом задания
Необходимо определить набор слов которые запрещено использовать в названии фильма
Создать собственную аннотацию (на весь класс или конкретное поле - по желанию) и обработчик
Проверить что при сохранении фильма мы получаем ошибку если в названии фильма присутствует одно из слов из черного списка
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson45BlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson45BlApplication.class, args);
    }

}
