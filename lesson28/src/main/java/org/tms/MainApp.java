/*
Реализовать проект - скачки.

Проект должен запускать гонку лошадей (5 кругов).
Пользователь вводит сумму ставки и номер пары, после этого гонка запускается.
Если выиграла пара, на которую ставил игрок он получает ставку назад, если проиграет - деньги списываются.

Создать три пары - лошадь и наездник

При возможности реализовать различный исход гонки.
До ввода пользователя вывести информацию и парах.

Все классы описать в конфигурации spring используя xml конфигурацию (лошади, наездники и пары так же)
*/

package org.tms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tms.domain.Horse;
import org.tms.domain.Jokey;
import org.tms.domain.Pairs;
import org.tms.service.AccountService;
import org.tms.service.PairService;
import org.tms.service.RaceService;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        RaceService bean = applicationContext.getBean(RaceService.class);

        bean.game();
    }
}