package ru.plushchov.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.plushchov.config.SpringConfig;
import ru.plushchov.model.Beverage;
import ru.plushchov.model.Equipment;
import ru.plushchov.model.Ingredient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
        EquipmentService equipmentService = (EquipmentService) context.getBean("equipmentServiceImpl");



        Ingredient coffeeBeans = new Ingredient();
        coffeeBeans.setOrigin("Brazil");
        coffeeBeans.setAmount(new BigDecimal("200.00"));
        coffeeBeans.setId(UUID.randomUUID());
        coffeeBeans.setPrice(new BigDecimal("10.20"));

        ingredientService.addIngredient(coffeeBeans);

        Ingredient milk = new Ingredient();
        milk.setOrigin("Russia");
        milk.setAmmount(new BigDecimal("10.00"));
        milk.setId(UUID.randomUUID());
        milk.setPrice(new BigDecimal("2.20"));

        ingredientService.addIngredient(milk);

        List cappuccinoIngredientList = new ArrayList();

        cappuccinoIngredientList.add(coffeeBeans);
        cappuccinoIngredientList.add(milk);


        Equipment coffeeMachine = new Equipment();
        coffeeMachine.setId(UUID.randomUUID());
        coffeeMachine.setName("Marzoka coffeeMachine");

        equipmentService.addEquipment(coffeeMachine);

        Equipment grinder = new Equipment();
        grinder.setId(UUID.randomUUID());
        grinder.setName("Simonelli mythos grinder");

        equipmentService.addEquipment(grinder);

        List cappuccinoEquipmentList = new ArrayList();
        cappuccinoEquipmentList.add(coffeeMachine);
        cappuccinoEquipmentList.add(grinder);

        Beverage cappuccino = new Beverage("Cappuccino");
        cappuccino.setId(UUID.randomUUID());
        cappuccino.setBeveragePrice(new BigDecimal("5.50"));
        cappuccino.setIngredientList(cappuccinoIngredientList);
        cappuccino.setEquipmentList(cappuccinoEquipmentList);



    }
}
