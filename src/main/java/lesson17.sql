-- [1] таблица для хранения данных о человеке
create table if not exists persons (
                                       id int primary key,              -- идентификатор человека
                                       first_name varchar not null ,    -- имя
                                       sex varchar not null ,           -- пол
                                       date_of_birth date not null      -- дата рождения
);

-- [2] таблица для хранения типов хобби
create table if not exists type (
                                    id int primary key,              -- идентификатор имени хобби
                                    name_of_type varchar             -- имя типа хобби
);

-- [3] таблица для хранения данных о хобби
create table if not exists hobbys (
                                      id int primary key,              -- идентификатор хобби
                                      name_of_hobby varchar,           -- название хобби
                                      type_of_hobby int constraint fk_type references type (id)    -- тип хобби
    );

-- [4] таблица для хранения данных о человеке и его хобби
create table if not exists person_hobby (
                                            id int primary key,
                                            person_id int constraint fk_person references persons (id),
    hobby_id int constraint fk_hobby references hobbys (id)
    );

-- создаем 10 записей в таблице для хранения людей
insert into persons (id, first_name, sex, date_of_birth) values
                                                             (1, 'Станислав', 'мужчина', '1998-10-10'),
                                                             (2, 'Евгений', 'мужчина', '1996-03-07'),
                                                             (3, 'Ульяна', 'женщина', '2001-04-15'),
                                                             (4, 'Константин', 'мужчина', '2000-10-10'),
                                                             (5, 'Алеся', 'женщина', '2002-05-12'),
                                                             (6, 'Анастасия', 'женщина', '2002-06-04'),
                                                             (7, 'Ангелина', 'женщина', '2003-11-13'),
                                                             (8, 'Константин', 'мужчина', '1995-08-15'),
                                                             (9, 'Марк', 'мужчина', '2001-11-16'),
                                                             (10, 'Даниил', 'мужчина', '2002-01-05');

-- создаем два типа хобби
insert into type (id, name_of_type) values
                                        (1, 'активное'),
                                        (2, 'пассивное');

-- создаем разновидности активного (1) и пассивного (2) хобби
insert into hobbys (id, name_of_hobby, type_of_hobby) values
                                                          (1, 'программирование', 2),
                                                          (2, 'фехтование', 1),
                                                          (3, 'хоккей', 1),
                                                          (4, 'бокс', 2),
                                                          (5, 'чтение', 2),
                                                          (6, 'плавание', 1),
                                                          (7, 'рисование', 2),
                                                          (8, 'коллекционирование', 2),
                                                          (9, 'хоббихорсинг', 1),
                                                          (10, 'бег', 1);

-- создаем записи для хранения данных о хобби для каждого человека
insert into person_hobby (id, person_id, hobby_id) values
                                                       (1, 1, 3),
                                                       (2, 1, 4),
                                                       (3, 1, 9),
                                                       (4, 2, 2),
                                                       (5, 3, 1),
                                                       (6, 3, 7),
                                                       (7, 3, 6),
                                                       (8, 3, 10),
                                                       (9, 4, 3),
                                                       (10, 5, 1),
                                                       (11, 6, 1),
                                                       (12, 7, 4),
                                                       (13, 7, 5),
                                                       (14, 7, 10),
                                                       (15, 8, 7),
                                                       (16, 8, 8),
                                                       (17, 9, 5),
                                                       (18, 9, 8),
                                                       (19, 9, 10),
                                                       (20, 10, 1),
                                                       (21, 10, 10);

-- удаление созданных таблиц
drop table if exists persons;
drop table if exists hobbys;
drop table if exists type;
drop type if exists person_hobby;

-- выводим список всех людей старше какого-либо возраста
select * from persons where age(date_of_birth) > interval '23 years';

-- выводим информацию о том, сколько людей каждого пола есть в базе данных
select sex, count(*) from persons group by sex;

-- выводим информацию о людях и их хобби
select p.id, first_name, sex, date_of_birth, name_of_hobby from persons p
                                                                    join person_hobby ph on p.id = ph.person_id
                                                                    join hobbys h on h.id = ph.hobby_id;

-- выводим информацию о людях, у которых более одного хобби
select p.id, first_name, sex, date_of_birth,count(name_of_hobby) as sum_of_hobbys from persons p
                                                                                           join person_hobby ph on p.id = ph.person_id
                                                                                           join hobbys h on h.id = ph.hobby_id
group by p.id, first_name, sex, date_of_birth
having count(name_of_hobby) > 1
order by p.id;


-- выводим количество активных и пассивных хобби в бд
select name_of_type, count(*) from type t
                                       join hobbys h on t.id = h.type_of_hobby
group by name_of_type;

-- выводим информацию, какое хобби активное, а какое пассивное
select h.id, name_of_hobby, name_of_type from hobbys h join type t on t.id = h.type_of_hobby;