/*
В рамках данного задания необходимо создать две формы
1) для регистрации нового пользователя
2) для аутентификации пользователя
Пользователей необходимо хранить в бд
Необходимо обеспечить шифрование паролей
Необходимо добавить кнопку - logout
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson48Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson48Application.class, args);
    }

}