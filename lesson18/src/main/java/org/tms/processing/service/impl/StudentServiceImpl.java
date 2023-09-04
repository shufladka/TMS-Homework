package org.tms.processing.service.impl;

import org.tms.processing.config.DataBaseConnectionConfig;
import org.tms.processing.domain.Student;
import org.tms.processing.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public void save(Student student) {

        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSetForId = statement.executeQuery("select max(id) + 1 from students");

            int nextId = 0;
            if (resultSetForId.next()) {
                nextId = resultSetForId.getInt(1);
            }

            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into students (id, first_name, last_name, sex, date_of_birth) values (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, nextId);
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());

            if (student.getSex() == "man" || student.getSex() == "woman") {
                preparedStatement.setString(4, student.getSex());
            } else {
                System.out.println("Пол студента следует указывать как 'man' (мужчина) или 'woman' (женщина).");
                student.setSex("null");
                preparedStatement.setString(4, student.getSex());
            }

            if (student.getDateOfBirth() != null) {
                java.util.Date birthday = student.getDateOfBirth();
                long time = birthday.getTime();
                java.sql.Date date = new java.sql.Date(time);
                preparedStatement.setDate(5, date);
            } else {
                preparedStatement.setDate(5, null);
            }

            preparedStatement.execute();

            System.out.println("Данные нового пользователя с идентификатором '" + nextId + "' были успешно добавлены в базу данных.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student findById(Integer id) {

        try (Connection connection1 = DataBaseConnectionConfig.getConnection(); Connection connection2 = DataBaseConnectionConfig.getConnection()) {

            PreparedStatement preparedStatementStudent = connection1.prepareStatement("select * from students where id = ?");
            PreparedStatement preparedStatementCityName = connection2.prepareStatement("select name_of_city from cities с join students s on с.id = s.city_id where s.id = ?");

            preparedStatementStudent.setInt(1, id);
            preparedStatementCityName.setInt(1, id);

            ResultSet resultSetStudent = preparedStatementStudent.executeQuery();
            ResultSet resultSetCityName = preparedStatementCityName.executeQuery();

            if (resultSetStudent.next()) {

                int studentId = resultSetStudent.getInt("id");
                String firstName = resultSetStudent.getString("first_name");
                String lastName = resultSetStudent.getString("last_name");
                String sex = resultSetStudent.getString("sex");
                Date dateOfBirth = resultSetStudent.getDate("date_of_birth");

                String city = "null";
                if (resultSetCityName.next()) {
                    city = resultSetCityName.getString("name_of_city");
                    city = (city != null) ? city : "unnamed";
                }

                System.out.println("Пользователь с идентификатором '" + id + "' найден!");
                return new Student(studentId, firstName, lastName, sex, dateOfBirth, city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Student> findAllStudents() {

        List<Student> studentList = new ArrayList<>();

        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statementStudent = connection.createStatement();
            Statement statementStudentCity = connection.createStatement();

            ResultSet resultSetStudent = statementStudent.executeQuery("select * from students");
            ResultSet resultSetStudentCity = statementStudentCity.executeQuery("select name_of_city from cities с join students s on с.id = s.city_id");

            while (resultSetStudent.next()) {
                int studentId = resultSetStudent.getInt("id");
                String firstName = resultSetStudent.getString("first_name");
                String lastName = resultSetStudent.getString("last_name");
                String sex = resultSetStudent.getString("sex");
                Date dateOfBirth = resultSetStudent.getDate("date_of_birth");

                String city = "null";
                if (resultSetStudentCity.next()) {
                    city = resultSetStudentCity.getString("name_of_city");
                    city = (city != null) ? city : "unnamed";
                }

                Student student = new Student(studentId, firstName, lastName, sex, dateOfBirth, city);
                studentList.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Список всех студентов, информация о которых есть в базе данных:");
        return studentList;
    }

    @Override
    public void update(Student student, Integer id) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("update students set first_name = ?, last_name = ?, sex = ?, date_of_birth = ? where id = ?");

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getSex());

            if (student.getDateOfBirth() != null) {
                java.util.Date birthday = student.getDateOfBirth();
                long time = birthday.getTime();
                java.sql.Date date = new java.sql.Date(time);
                preparedStatement.setDate(4, date);
            } else {
                preparedStatement.setDate(4, null);
            }

            preparedStatement.setInt(5, id);
            preparedStatement.execute();

            System.out.println("Данные пользователя с идентификатором '" + id + "' были успешно изменены.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            System.out.println("Данные пользователя с идентификатором '" + id + "' были успешно удалены.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setCityToStudent(Integer studentId, String cityName) {
        try (Connection connection = DataBaseConnectionConfig.getConnection()) {
            Statement statement = connection.createStatement();

            // корректировка высоты символов получаемого имени для корректного поиска в базе данных cities
            if (cityName != null) {
                char firstLetter = cityName.toUpperCase().charAt(0);
                cityName = firstLetter + cityName.toLowerCase().substring(1);
            }

            ResultSet resultSet = statement.executeQuery("select id from cities where name_of_city = '" + cityName + "'");

            int nextId = 0;
            if (resultSet.next()) {
                nextId = resultSet.getInt(1);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("update students set city_id = ? where id = ?");
            preparedStatement.setInt(1, nextId);
            preparedStatement.setInt(2, studentId);

            preparedStatement.execute();

            System.out.println("Сведения о родном городе пользователя с идентификатором '" + studentId + "' была успешно изменена.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}