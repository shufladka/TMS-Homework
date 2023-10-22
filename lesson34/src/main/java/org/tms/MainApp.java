/*
Необходимо создать две Entity - Person и Phone
Отношение должно быть двунаправленное (связь OneToMany - ManyToOne)
Добавить следующие типы полей
	String (длинна до 1024)
	Boolean
	Date (только дата без времени)
	Enum (сохранение в виде строк)

Реализовать функционал по сохранению и получению сведения о Person по Id
*/

package org.tms;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tms.config.HibernateConfig;
import org.tms.entity.Operator;
import org.tms.entity.PersonEntity;
import org.tms.entity.PhoneEntity;
import org.tms.entity.Role;
import org.tms.service.PersonService;

import java.util.Date;
import java.util.UUID;

public class MainApp {
    public static void main(String[] args) {

//        createTables();

        PersonService service = new PersonService();

        PersonEntity firstPerson = PersonEntity.builder()
                .firstName("Pavel")
                .lastName("Pavlov")
                .isMarried(true)
                .dateOfBirth(new Date())
                .role(Role.ARCHITECT)
                .build();

        UUID uuid = service.savePerson(firstPerson);
        service.getPerson(uuid);
    }

    // метод предназначен для создания таблиц людей и телефонов в случае отладки программы
    private static void createTables() {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        PersonEntity firstPerson = PersonEntity.builder()
                .firstName("Pavel")
                .lastName("Pavlov")
                .isMarried(true)
                .dateOfBirth(new Date())
                .role(Role.ARCHITECT)
                .build();

        PhoneEntity firstPhone = PhoneEntity.builder()
                .number("+375291234567")
                .isBlocked(false)
                .dateOfActivate(new Date())
                .operator(Operator.A1)
                .build();

        PhoneEntity secondPhone = PhoneEntity.builder()
                .number("+375333333333")
                .isBlocked(false)
                .dateOfActivate(new Date())
                .operator(Operator.MTS)
                .build();

        PhoneEntity thirdPhone = PhoneEntity.builder()
                .number("+375257654321")
                .isBlocked(false)
                .dateOfActivate(new Date())
                .operator(Operator.LIFE)
                .build();

        session.save(firstPerson);
        session.save(firstPhone);
        session.save(secondPhone);
        session.save(thirdPhone);

        transaction.commit();
        session.close();
    }
}