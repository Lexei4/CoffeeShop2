package ru.plushchov.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//@Configuration
public class RepositoryConfig {
    @Bean
    @Primary
    public BeverageDAO getBeverageDAO() {

        return new BeverageDAOImpl();
    }

    @Bean
    @Primary
    public IngredientDAO getIngredientDAO() {

        return new IngredientDAOImpl();
    }

    @Bean
    @Primary
    public EquipmentDAO getEquipmentDAO() {

        return new EquipmentDAOImpl();
    }

}
