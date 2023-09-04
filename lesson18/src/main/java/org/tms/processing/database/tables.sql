-- [1] таблица для хранения городов
create table if not exists cities (
    id int primary key,              -- идентификатор города
    name_of_city varchar             -- название города
);

-- [2] таблица для хранения данных о студентах
create table if not exists students (
    id int primary key,              -- идентификатор студента
    first_name varchar not null ,    -- имя
    last_name varchar not null,      -- фамилия
    sex varchar not null,            -- пол
    date_of_birth date,              -- дата рождения
    city_id int constraint fk_cities references cities(id)  -- ключ соответствующей колонки в таблице городов
);

-- добавляем новые данные в таблицу городов
insert into cities (id, name_of_city) values (1, 'Minsk'),
                                             (2, 'Vitebsk'),
                                             (3, 'Grodno'),
                                             (4, 'Mogilev'),
                                             (5, 'Mozyr'),
                                             (6, 'Petrikov'),
                                             (7, 'Soligorsk'),
                                             (8, 'Lida'),
                                             (9, 'Grodno');

-- добавляем новые данные в таблицу студентов
insert into students (id, first_name, last_name, sex, date_of_birth, city_id) values (1, 'Leonid', 'Kondratiev', 'man', '1999-12-21', 2),
                                                                                     (2, 'Alyona', 'Petrova', 'woman', '1999-06-14', 7),
                                                                                     (3, 'Anna', 'Trovimova', 'woman', '2001-04-25', 8),
                                                                                     (4, 'Stanislav', 'Kovalenya', 'man', '2000-09-30', 6),
                                                                                     (5, 'Kirill', 'Bura', 'man', '2002-10-16',3),
                                                                                     (6, 'Ilya', 'Zhudro', 'man', '2002-08-12', 4);