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
Необходимо определить набор слов которые запрещено использовать в названии автомобиля
Создать собственную аннотацию (на весь класс или конкретное поле - по желанию) и обработчик
Проверить, что при сохранении машины мы получаем ошибку если в названии машины присутствует одно из слов из черного списка
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.tms.client.CarClient;

@SpringBootApplication
@EnableFeignClients(clients = {CarClient.class})
public class Lesson45IlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson45IlApplication.class, args);
    }

}
