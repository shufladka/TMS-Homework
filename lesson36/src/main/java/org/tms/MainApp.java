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

------------------ NEW TASK -----------------------------
Улучшаем пред домашку

При помощи criteria создать поиск по полям (поиск может включать произвольные фильтры)
	1) диапазон дат рождения
	2) по типу пользователя (user, admin)
	3) найти пользователей у кого есть задачи с определенным статусом
*/

package org.tms;

import org.tms.entity.*;
import org.tms.entity.additions.Sex;
import org.tms.entity.additions.TaskStatus;
import org.tms.entity.additions.UserType;
import org.tms.service.search.CriteriaSearch;
import org.tms.service.impl.UserServiceImpl;
import org.tms.service.impl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        // создаем объекты классов-имплементаций
        UserServiceImpl userService = new UserServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();

        // создаем пользователей
        UserEntity firstUser = userService.create("Pavel", LocalDate.of(2001,5,18), Sex.MALE, UserType.USER);
        UserEntity secondUser = userService.create("Anna", LocalDate.of(2003,3,5), Sex.FEMALE, UserType.ADMIN);

        // создаем задачи
        TaskEntity firstTask = taskService.create("Daily", "Make a payment", TaskStatus.NEW, firstUser);
        TaskEntity secondTask = taskService.create("Urgent", "Look at the kittens", TaskStatus.NEW, firstUser);
        TaskEntity thirdTask = taskService.create("Daily", "Discuss colleagues", TaskStatus.NEW, secondUser);
        TaskEntity fourthTask = taskService.create("Urgent", "Meet on Zoom", TaskStatus.NEW, secondUser);

        // назначаем задачи
        firstUser.addNewTask(firstTask);
        firstUser.addNewTask(secondTask);
        secondUser.addNewTask(thirdTask);
        secondUser.addNewTask(fourthTask);

        // обновляем статус задач
        taskService.refreshStatus(secondTask.getTaskId(), TaskStatus.IN_PROGRESS);
        taskService.refreshStatus(thirdTask.getTaskId(), TaskStatus.DONE);

        // выводим пользователей с активными задачами
        List<UserEntity> busyUsers = userService.findBusyUsers(TaskStatus.DONE);
        System.out.println(busyUsers);

        // ищем пользователей согласно условию задачи
        System.out.println(" ");
        System.out.println(CriteriaSearch.personCriteria(firstUser));

        // удаляем всех пользователей
        userService.delete(firstUser);
        userService.delete(secondUser);
    }
}