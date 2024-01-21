/*
Необходимо создать три страницы и организовать необходимый доступ к ним
1) страница с доступом всех
2) страница с доступом авторизованных пользователей
3) страница с доступом пользователей с привилегией - access

Для хранения пользователей используем хранения в памяти
*/

package org.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson47Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson47Application.class, args);
	}

}
