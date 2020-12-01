package ru.plushchov.dao;

import org.springframework.context.annotation.Bean;

public class RepositoryConfig {
    @Bean
    public BeverageDAO getBeverageDAO() {

        return new BeverageDAOImpl();
    }

    @Bean
    public IngredientDAO getIngredientDAO() {

        return new IngredientDAOImpl();
    }
}
