package service;

import model.Ingredient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        /*
        1. Create all neseccary equipment
        2. Lazy initializations of ingredients
        3. Ready to serve orders
        master branch
         */

        IngredientService ingredientService = (IngredientService) context.getBean("ingredientService");

        Ingredient coffeeBeans = new Ingredient();
        coffeeBeans.setOrigin("Brazil");
        coffeeBeans.setAmount(new BigDecimal("200.00"));
        coffeeBeans.setId(UUID.randomUUID());
        coffeeBeans.setPrice(new BigDecimal("10.20"));

        ingredientService.addIngredient(coffeeBeans);


    }
}
