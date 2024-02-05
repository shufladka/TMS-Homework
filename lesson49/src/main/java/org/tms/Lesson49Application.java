/*
Создаем рест приложение
Делаем запрос для получения токена
Токен должен хранить имя пользователя, его номер телефона, его роли
Создаем ендпоинт защищеный spring security - доступ к нему разрешается только тем у кого есть роль ADMIN
Тестируем что пользователи с токеном и ролью ADMIN могут зайти на данный ендпоинт
Хранение пользователь сделать любым способом
Создание пользователя не обязательно (предустановленый список)
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson49Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson49Application.class, args);
    }

}