/*
Необходимо создать RestController с методом POST по созданию сущности - Заказ.
Данный эндпоинт возвращает сохраненный заказ (добавляет id)
Написать тест который будет проверять работоспособность ендпоинта (MockMvc).
Проверить наличие всех необходимых полей.
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson51Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson51Application.class, args);
    }

}