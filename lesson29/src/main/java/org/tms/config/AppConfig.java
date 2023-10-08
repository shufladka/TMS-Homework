package org.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.tms.domain.Horse;
import org.tms.domain.Jokey;
import org.tms.domain.Pairs;
import org.tms.service.AccountService;
import org.tms.service.PairService;
import org.tms.service.RaceService;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.tms.service")
public class AppConfig {

    // --------- Первая пара ---------
    @Bean
    Jokey jokey1() {
        return new Jokey("Pavel", "Petrov");
    }
    @Bean
    Horse horse1() {
        return new Horse("Alyaska", 0.17);
    }

    // --------- Вторая пара ---------
    @Bean
    Jokey jokey2() {
        return new Jokey("Konstantin", "Konstantinov");
    }
    @Bean
    Horse horse2() {
        return new Horse("Sonya", 0.19);
    }

    // --------- Третья пара ---------
    @Bean
    Jokey jokey3() {
        return new Jokey("Eugene", "Prigozhin");
    }
    @Bean
    Horse horse3() {
        return new Horse("Morgana", 0.15);
    }


    @Bean
    Pairs pair1() {
        return new Pairs(jokey1(), horse1());
    }
    @Bean
    Pairs pair2() {
        return new Pairs(jokey2(), horse2());
    }
    @Bean
    Pairs pair3() {
        return new Pairs(jokey3(), horse3());
    }


    @Bean
    AccountService accountService(){
        return new AccountService();
    }

    @Bean
    PairService pairs(List<Pairs> pairs){
        return new PairService(pairs);
    }

    @Bean
    @Scope("singleton")
    RaceService raceService(AccountService accountService, PairService pairService){
        return new RaceService(accountService, pairService);
    }
}