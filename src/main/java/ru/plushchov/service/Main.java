package ru.plushchov.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.plushchov.config.*;
import ru.plushchov.model.Ingredient;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        /*
        1. Create all neseccary equipment
        2. Lazy initializations of ingredients
        3. Ready to serve orders
        master branch
         */

        IngredientService ingredientService = (IngredientService) context.getBean("ingredientServiceImpl");



        Ingredient coffeeBeans = new Ingredient();
        coffeeBeans.setOrigin("Brazil");
        coffeeBeans.setAmount(new BigDecimal("200.00"));
        coffeeBeans.setId(UUID.randomUUID());
        coffeeBeans.setPrice(new BigDecimal("10.20"));

        ingredientService.addIngredient(coffeeBeans);


    }
}
