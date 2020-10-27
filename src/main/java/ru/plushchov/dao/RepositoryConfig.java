package ru.plushchov.dao;

import org.springframework.context.annotation.Bean;

//@Configuration
public class RepositoryConfig {
    @Bean
//    @Primary
    public BeverageDAO getBeverageDAO() {

        return new BeverageDAOImpl();
    }

    @Bean
//    @Primary
    public IngredientDAO getIngredientDAO() {

        return new IngredientDAOImpl();
    }

}
