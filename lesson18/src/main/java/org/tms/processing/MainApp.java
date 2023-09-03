/*
Создать таблицу с данными студентов группы.
Создать Java приложение для получения списка всех студентов группы.
Создать таблицу с городами, где живут студенты.
Вывести информацию о каждом студенте группы и его родном городе.
Предусмотреть операции добавления новых городов, новых студентов, удаления студентов и удаления городов.
*/

package org.tms.processing;

import org.tms.processing.domain.City;
import org.tms.processing.domain.Student;
import org.tms.processing.service.impl.CityServiceImpl;
import org.tms.processing.service.impl.StudentServiceImpl;

import java.util.Date;

//import java.util.Date;


public class MainApp {
    public static void main(String[] args) {

        // создаем объекты классов StudentServiceImpl и CityServiceImpl для работы с созданными методами взаимодействия с БД
        StudentServiceImpl studentService = new StudentServiceImpl();
        CityServiceImpl cityService = new CityServiceImpl();

        // добавляем нового студента в базу данных
        studentService.save(new Student("Konstantin", "Konstantinov", "helicopter", new Date()));
        System.out.println("");

        // выводим информацию о всех студентах, хранимую в базе данных
        System.out.println(studentService.findAllStudents());
        System.out.println("");

        // находим студента по идентификатору
        System.out.println(studentService.findById(4));
        System.out.println("");

        // устанавливаем студенту информацию о родном городе
        studentService.setCityToStudent(3, "Soligorsk");
        System.out.println("");

        // удаляем информацию о студенте
        studentService.delete(7);
        System.out.println("");

        // добавляем в базу данных информацию о новом городе
        cityService.save(new City("Brest"));
        System.out.println("");

        // выводим на консоль информацию обо всех городах, хранимых базой данных
        System.out.println(cityService.findAllCities());
        System.out.println("");

        // находим город по идентификатору
        System.out.println(cityService.findById(3));
        System.out.println("");

        // меняем название города по идентификатору
        cityService.update(new City("Baranovichi"), 6);
        System.out.println("");

        // удаляем город по идентификатору
        cityService.deleteById(5);
    }
}
