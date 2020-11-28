package ru.plushchov.service;

import org.springframework.context.annotation.Bean;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.dao.IngredientDAO;

//@Configuration

public class ServiceConfig {
    @Bean
    public IngredientService ingredientServiceImpl(IngredientDAO ingredientDAO) {

        return new IngredientServiceImpl(ingredientDAO);
    }

    @Bean
    public BeverageService beverageServiceImpl(BeverageDAO beverageDAO) {

        return new BeverageServiceImpl(beverageDAO);
    }
}
