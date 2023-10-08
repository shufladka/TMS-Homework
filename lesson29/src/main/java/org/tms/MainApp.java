/*
перевод xml конфигурации на java + annotation
*/

package org.tms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tms.service.RaceService;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.tms.config");
        context.registerShutdownHook();

        RaceService bean = context.getBean(RaceService.class);

        bean.game();

    }
}