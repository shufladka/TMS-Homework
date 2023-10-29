/*
Создаем CRUD сервис для работы с сущностью - пользователь
Необходимо описать пользователя
	имя
	тип (enum - user, admin, support)
	дата рождения
	пол
Создать сущность - задача
	заглавие
	описание
	статус (enum - new, in_progress, done)
Между данными таблицами организовать отношение один-ко-многим (у одного пользователя может быть несколько тасок)

Создать сервисы для
	сохранения, обновления, удаления, получения по ид пользователя
	добавления, изменения статуса текущей задачи, получения задачи по ид, получения задач по пользователю
	поиск пользователей у которых есть активные задачи
При необходимости добавить другие методы

Тестирование - Создаем пользователей (2 шт)
Каждому назначаем несколько задач
Обновляем статусы некоторых из задач
Делаем поиск пользователей у которых есть активные задачи
Удаляем всех пользователей
*/

package org.tms;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tms.config.HibernateConfig;
import org.tms.entity.*;
import org.tms.service.impl.UserServiceImpl;
import org.tms.service.impl.TaskServiceImpl;

import java.util.Date;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        createTables();

//        // создаем объекты классов-имплементаций
//        UserServiceImpl userService = new UserServiceImpl();
//        TaskServiceImpl taskService = new TaskServiceImpl();
//
//        // создаем пользователей
//        UserEntity firstUser = userService.create("Pavel", new Date(), Sex.MALE, UserType.USER);
//        UserEntity secondUser = userService.create("Anna", new Date(), Sex.FEMALE, UserType.ADMIN);
//
//        // создаем задачи
//        TaskEntity firstTask = taskService.create("Daily", "Make a payment", TaskStatus.NEW, firstUser);
//        TaskEntity secondTask = taskService.create("Urgent", "Look at the kittens", TaskStatus.NEW, firstUser);
//        TaskEntity thirdTask = taskService.create("Daily", "Discuss colleagues", TaskStatus.NEW, secondUser);
//        TaskEntity fourthTask = taskService.create("Urgent", "Meet on Zoom", TaskStatus.NEW, secondUser);
//
//        // назначаем задачи
//        firstUser.addNewTask(firstTask);
//        firstUser.addNewTask(secondTask);
//        secondUser.addNewTask(thirdTask);
//        secondUser.addNewTask(fourthTask);
//
//        // обновляем статус задач
//        taskService.refreshStatus(secondTask, TaskStatus.IN_PROGRESS);
//        taskService.refreshStatus(thirdTask, TaskStatus.DONE);
//
//        // выводим пользователей с активными задачами
//        List<UserEntity> busyUsers = userService.findBusyUsers(TaskStatus.DONE);
//        System.out.println(busyUsers);
//
//        // удаляем всех пользователей
//        userService.delete(firstUser);
//        userService.delete(secondUser);
    }

    // метод предназначен для создания таблиц людей и телефонов в случае отладки программы
    private static void createTables() {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        UserEntity user = UserEntity.builder()
                .name("Pavel")
                .dateOfBirth(new Date())
                .sex(Sex.MALE)
                .userType(UserType.USER)
                .build();

        TaskEntity firstTask = TaskEntity.builder()
                .header("Urgent")
                .description("Look at the kittens")
                .taskStatus(TaskStatus.NEW)
                .userEntity(user)
                .build();

        TaskEntity secondTask = TaskEntity.builder()
                .header("Daily")
                .description("Make a payment")
                .taskStatus(TaskStatus.NEW)
                .userEntity(user)
                .build();

        session.save(user);
        session.save(firstTask);
        session.save(secondTask);

        transaction.commit();
        session.close();
    }
}