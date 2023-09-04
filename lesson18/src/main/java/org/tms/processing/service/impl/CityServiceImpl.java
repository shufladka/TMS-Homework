package org.tms.processing.service.impl;

import org.tms.processing.config.DataBaseConnectionConfig;
import org.tms.processing.domain.City;
import org.tms.processing.service.CityService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {

    @Override
    public void save(City city) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statement = connection.createStatement();

            // проверка на дублирование городов в таблице cities
            ResultSet resultSet = statement.executeQuery("select * from cities");

            boolean found = true;
            while (resultSet.next()) {
                if (resultSet.getString(2).equalsIgnoreCase(city.getCityName())) {
                    System.out.println("Город с таким названием уже есть в базе данных.");
                    found = false;
                    break;
                }
            }

            // если дублей не было найдено, то вносим в таблицу новое поле
            if (found) {
                ResultSet resultSetForId = statement.executeQuery("select max(id) + 1 from cities");

                int nextId = 0;
                if (resultSetForId.next()) {
                    nextId = resultSetForId.getInt(1);
                }

                PreparedStatement preparedStatement = connection
                        .prepareStatement("insert into cities (id, name_of_city) values (?, ?)");

                preparedStatement.setInt(1, nextId);
                preparedStatement.setString(2, changeCaseOfCityName(city.getCityName()));

                preparedStatement.execute();

                System.out.println("Сведения о городе '" + changeCaseOfCityName(city.getCityName()) + "' успешно добавлены в базу данных.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public City findById(Integer id) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from cities where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cityId = resultSet.getInt("id");
                String cityName = resultSet.getString("name_of_city");

                System.out.println("Город с идентификатором '" + id + "' найден!");
                return new City(cityId, cityName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<City> findAllCities() {

        List<City> cityList = new ArrayList<>();

        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from cities");

            while (resultSet.next()) {
                int cityId = resultSet.getInt("id");
                String cityName = resultSet.getString("name_of_city");

                City city = new City(cityId, cityName);
                cityList.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Список всех городов, информация о которых есть в базе данных:");
        return cityList;
    }

    @Override
    public void update(City city, Integer id) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("update cities set name_of_city = ? where id = ?");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

            System.out.println("Данные города с идентификатором '" + id + "' были успешно изменены.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statement = connection.createStatement();

            // стираем сведения об удаляемом городе в таблице students
            ResultSet resultSet = statement.executeQuery("select id from students where city_id = " + id);
            while (resultSet.next()) {
                PreparedStatement preparedStatement = connection.prepareStatement("update students set city_id = null where id = ?");

                preparedStatement.setInt(1, resultSet.getInt(1));
                preparedStatement.execute();
            }

            PreparedStatement preparedStatement = connection.prepareStatement("delete from cities where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            System.out.println("Данные города с идентификатором '" + id + "' были успешно удалены.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // метод для корректировки высоты символов получаемого имени города (например, с "MInsK" на "Minsk")
    private String changeCaseOfCityName (String string) {
        char firstLetter = string.toUpperCase().charAt(0);
        return firstLetter + string.toLowerCase().substring(1);
    }
}