package org.tms.processing.service;

import org.tms.processing.domain.City;
import org.tms.processing.domain.Student;

import java.util.List;

public interface CityService {

    // сохранить данные о городе в базу данных
    void save(City city);

    // найти город по его идентификатору
    City findById(Integer id);

    // вывести информацию обо всех городах, хранимую в базе данных
    List<City> findAllCities();

    // обновить данные о городе, хранимые в базе данных
    void update(City city, Integer id);

    // удалить город по его идентификатору из базы данных
    void deleteById(Integer id);
}
