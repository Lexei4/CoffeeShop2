package ru.plushchov.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.plushchov.config.*;
import ru.plushchov.model.Ingridient;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        /*
        1. Create all neseccary equipment
        2. Lazy initializations of ingridients
        3. Ready to serve orders
        master branch
         */

        IngridientService ingridientService = (IngridientService) context.getBean("ingridientServiceImpl");



        Ingridient coffeeBeans = new Ingridient();
        coffeeBeans.setOrigin("Brazil");
        coffeeBeans.setAmmount(200.00);
        coffeeBeans.setId(UUID.randomUUID());
        coffeeBeans.setPrice(new BigDecimal("10.20"));

        ingridientService.addIngredient(coffeeBeans);


    }
}
