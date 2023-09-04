package org.tms.processing.service;

import org.tms.processing.domain.Student;

import java.util.List;

public interface StudentService {

    // сохранить данные о студенте в базу данных
    void save(Student student);

    // найти информацию о студенте по его идентификатору
    Student findById(Integer id);

    // вывести информацию обо всех студентах, хранимую в базе данных
    List<Student> findAllStudents();

    // обновить информацию о студенте, хранящуюся в базе данных
    void update(Student student, Integer id);

    // удалить информацию о студенте из базы данных
    void delete (Integer id);

    // установить студенту информацию о родном городе
    void setCityToStudent(Integer studentID, String cityName);
}
