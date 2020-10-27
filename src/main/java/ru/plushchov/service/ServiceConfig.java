package ru.plushchov.service;

import org.springframework.context.annotation.Bean;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.dao.IngridientDAO;

//@Configuration

public class ServiceConfig {
    @Bean
    public IngridientService ingridientServiceImpl(IngridientDAO ingridientDAO) {

        return new IngridientServiceImpl(ingridientDAO);
    }

    @Bean
    public BeverageService beverageServiceImpl(BeverageDAO beverageDAO) {

        return new BeverageServiceImpl(beverageDAO);
    }
}
