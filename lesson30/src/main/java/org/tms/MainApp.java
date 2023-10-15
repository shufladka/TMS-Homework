/*
перевод xml конфигурации на java + annotation
*/

package org.tms;

import org.tms.service.RaceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org/tms");
        context.registerShutdownHook();

        RaceService bean = context.getBean(RaceService.class);
        bean.game();
    }
}